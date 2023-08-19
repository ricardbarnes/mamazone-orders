package cat.vonblum.mamazone.producer.provider

import cat.vonblum.mamazone.order.Order
import cat.vonblum.mamazone.order.OrderProvider

class InMemoryOrderProvider : OrderProvider {
    override fun send(order: Order) {
        TODO("Not yet implemented")
    }

}