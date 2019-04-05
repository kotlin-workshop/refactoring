package movierental

/**
 * The rental class represents a customer renting a movie.
 */
class Rental(val movie: Movie, val daysRented: Int) {
    fun amount(): Double {
        var thisAmount = 0.0

        //determine amounts for each line
        when (movie.priceCode) {
            Movie.REGULAR -> {
                thisAmount += 2.0
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5
            }
            Movie.NEW_RELEASE -> thisAmount += (daysRented * 3).toDouble()
            Movie.CHILDRENS -> {
                thisAmount += 1.5
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5
            }
        }
        return thisAmount

    }

    fun renterPoints(): Int {
        // add frequent renter points
        // add bonus for a two day new release rental
        return if (movie.priceCode == Movie.NEW_RELEASE && daysRented > 1) 2 else 1
    }
}