package cat.vonblum.mamazone.product.aggregate

class ProductName(val value: String) {

    init {

        if (value.isEmpty()) {
            throw IllegalArgumentException("Product name cannot be empty.")
        }

    }

}