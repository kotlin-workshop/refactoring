package movierental

import java.util.ArrayList
import java.util.Collections

class CustomerBuilder {
    private var name = NAME
    private val rentals = ArrayList<Rental>()

    fun build(): Customer {
        val result = Customer(name)
        for (rental in rentals) {
            result.addRental(rental)
        }
        return result
    }

    fun withName(name: String): CustomerBuilder {
        this.name = name
        return this
    }

    fun withRentals(vararg rentals: Rental): CustomerBuilder {
        Collections.addAll(this.rentals, *rentals)
        return this
    }

    companion object {

        val NAME = "Gregroire"
    }
}