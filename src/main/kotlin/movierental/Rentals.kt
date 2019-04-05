package movierental

class Rentals: Iterable<Rental> {
    override fun iterator(): Iterator<Rental> = rentals.iterator()

    private val rentals = ArrayList<Rental>()
    fun add(rental: Rental) {
        rentals.add(rental)
    }
    fun totalAmount(): Double = rentals.sumByDouble { it.amount() }

    fun totalPoints(): Int = rentals.sumBy { it.renterPoints() }
}
