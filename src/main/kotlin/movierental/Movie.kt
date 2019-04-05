package movierental

class Movie(val title: String, var priceCode: Int) {
    companion object {
        val CHILDRENS = 2
        val NEW_RELEASE = 1
        val REGULAR = 0
    }
}