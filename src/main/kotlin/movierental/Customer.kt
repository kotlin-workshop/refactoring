package movierental

import java.util.ArrayList

class Customer(val name: String) {
    private val _rentals = ArrayList<Rental>()

    fun addRental(arg: Rental) {
        _rentals.add(arg)
    }

    fun statement(): String {
        var totalAmount = 0.0
        var frequentRenterPoints = 0
        var result = "Rental Record for $name\n"

        for (rental in _rentals) {
            frequentRenterPoints += rental.renterPoints()
            // show figures for this rental
            result += "\t" + rental.movie.title + "\t" + rental.amount().toString() + "\n"
            totalAmount += rental.amount()
        }

        // add footer lines
        result += "Amount owed is " + totalAmount.toString() + "\n"
        result += "You earned " + frequentRenterPoints.toString() + " frequent renter points"

        return result
    }

}