package cat.vonblum.mamazone.customer.aggregate

class CustomerSurname(val value: String) {

    init {

        if (value.isEmpty()) {
            throw IllegalArgumentException("Product surname cannot be empty.")
        }

    }

}