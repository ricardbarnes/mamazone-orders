package cat.vonblum.mamazone.orders.producer.repository

import cat.vonblum.mamazone.orders.order.Order
import cat.vonblum.mamazone.orders.order.OrderId
import cat.vonblum.mamazone.orders.order.OrderRepository
import org.springframework.stereotype.Component

@Component
class InMemoryOrderReadRepository : OrderRepository {

    override fun save(order: Order) {
        println("saving order $order")
    }

    override fun findById(orderId: OrderId): Order {
        TODO("Not yet implemented")
    }

    override fun deleteById(orderId: OrderId) {
        TODO("Not yet implemented")
    }
    
}