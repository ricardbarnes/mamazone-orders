package cat.vonblum.mamazone.producer.provider

import cat.vonblum.mamazone.order.aggregate.Order
import cat.vonblum.mamazone.order.port.OrderProvider

class InMemoryOrderProvider : OrderProvider {
    override fun send(order: Order) {
        TODO("Not yet implemented")
    }

}