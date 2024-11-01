package cat.vonblum.mamazone.orders.producer.provider

import cat.vonblum.mamazone.orders.order.Order
import cat.vonblum.mamazone.orders.order.OrderProvider
import org.springframework.stereotype.Component

@Component
class InMemoryOrderProvider : OrderProvider {

    override fun send(order: Order) {
        println("sending order $order")
    }

}