package cat.vonblum.mamazone.order

import cat.vonblum.mamazone.shared.domain.error.Error

class OrderNotFoundError(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(orderId: OrderId): OrderNotFoundError = OrderNotFoundError("Order ${orderId.value} not found.")

    }

}