package cat.vonblum.mamazone.customer

class CustomerSurname(val value: String) {

    init {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Product surname cannot be empty.")
        }
    }

}