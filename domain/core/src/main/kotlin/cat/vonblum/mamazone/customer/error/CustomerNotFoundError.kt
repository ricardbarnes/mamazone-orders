package cat.vonblum.mamazone.customer.error

import cat.vonblum.mamazone.customer.aggregate.CustomerId
import cat.vonblum.mamazone.shared.domain.error.Error

class CustomerNotFoundError(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(customerId: CustomerId): CustomerNotFoundError =
            CustomerNotFoundError("Customer with id ${customerId.value} not found.")

    }

}