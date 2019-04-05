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

    fun htmlStatement(): String {
        var result = "<H1>Rentals for <EM>$name</EM></H1><P>\n"
        for (each in _rentals) {
            // show figures for this rental
            result += "${each.movie.title}: ${each.amount()}<BR>\n"
        }
        // add footer lines
        result += "<P>You owe <EM>${_rentals.totalAmount()}</EM><P>\n"
        result += "On this rental you earned <EM>${_rentals.totalPoints()}</EM> frequent renter points<P>"

        return result //To change body of created functions use File | Settings | File Templates.
    }
}