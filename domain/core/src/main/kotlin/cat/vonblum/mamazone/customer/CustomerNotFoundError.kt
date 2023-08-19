package cat.vonblum.mamazone.customer

import cat.vonblum.mamazone.shared.domain.error.Error

class CustomerNotFoundError(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(customerId: CustomerId): CustomerNotFoundError =
            CustomerNotFoundError("Customer with id ${customerId.value} not found.")

    }

}