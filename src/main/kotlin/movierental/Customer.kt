package movierental

class Customer(val name: String) {
    private val _rentals = Rentals()

    fun addRental(arg: Rental) {
        _rentals.add(arg)
    }

    fun statement(): String {
        var result = "Rental Record for $name\n"
        for (rental in _rentals) {
            // show figures for this rental
            result += "\t" + rental.movie.title + "\t" + rental.amount().toString() + "\n"
        }
        // add footer lines
        result += "Amount owed is " + _rentals.totalAmount().toString() + "\n"
        result += "You earned " + _rentals.totalPoints().toString() + " frequent renter points"
        return result
    }
}