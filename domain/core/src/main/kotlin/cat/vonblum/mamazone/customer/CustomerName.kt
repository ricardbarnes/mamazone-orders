package cat.vonblum.mamazone.customer

class CustomerName(val value: String){

    init {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Customer name cannot be empty.")
        }
    }

}