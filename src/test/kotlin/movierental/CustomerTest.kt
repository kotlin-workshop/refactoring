package movierental

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class CustomerTest {

    @Test
    fun testCustomer() {
        val c = CustomerBuilder().build()
        assertNotNull(c)
    }

    @Test
    fun testAddRental() {
        val customer2 = CustomerBuilder().withName("Sallie").build()
        val movie1 = Movie("Gone with the Wind", Movie.REGULAR)
        val rental1 = Rental(movie1, 3) // 3 day rental
        customer2.addRental(rental1)
    }

    @Test
    fun testGetName() {
        val c = Customer("David")
        assertEquals("David", c.name)
    }

    @Test
    fun statementForRegularMovie() {
        val movie1 = Movie("Gone with the Wind", Movie.REGULAR)
        val rental1 = Rental(movie1, 3) // 3 day rental
        val customer2 = CustomerBuilder()
                .withName("Sallie")
                .withRentals(rental1)
                .build()
        val expected = "Rental Record for Sallie\n" +
                "\tGone with the Wind\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points"
        val statement = customer2.statement()
        assertEquals(expected, statement)
    }

    @Test
    fun statementForNewReleaseMovie() {
        val movie1 = Movie("Star Wars", Movie.NEW_RELEASE)
        val rental1 = Rental(movie1, 3) // 3 day rental
        val customer2 = CustomerBuilder()
                .withName("Sallie")
                .withRentals(rental1)
                .build()
        val expected = "Rental Record for Sallie\n" +
                "\tStar Wars\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points"
        val statement = customer2.statement()
        assertEquals(expected, statement)
    }

    @Test
    fun statementForChildrensMovie() {
        val movie1 = Movie("Madagascar", Movie.CHILDRENS)
        val rental1 = Rental(movie1, 3) // 3 day rental
        val customer2 = CustomerBuilder()
                .withName("Sallie")
                .withRentals(rental1)
                .build()
        val expected = "Rental Record for Sallie\n" +
                "\tMadagascar\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points"
        val statement = customer2.statement()
        assertEquals(expected, statement)
    }

    @Test
    fun statementForManyMovies() {
        val movie1 = Movie("Madagascar", Movie.CHILDRENS)
        val rental1 = Rental(movie1, 6) // 6 day rental
        val movie2 = Movie("Star Wars", Movie.NEW_RELEASE)
        val rental2 = Rental(movie2, 2) // 2 day rental
        val movie3 = Movie("Gone with the Wind", Movie.REGULAR)
        val rental3 = Rental(movie3, 8) // 8 day rental
        val customer1 = CustomerBuilder()
                .withName("David")
                .withRentals(rental1, rental2, rental3)
                .build()
        val expected = "Rental Record for David\n" +
                "\tMadagascar\t6.0\n" +
                "\tStar Wars\t6.0\n" +
                "\tGone with the Wind\t11.0\n" +
                "Amount owed is 23.0\n" +
                "You earned 4 frequent renter points"
        val statement = customer1.statement()
        assertEquals(expected, statement)
    }

}