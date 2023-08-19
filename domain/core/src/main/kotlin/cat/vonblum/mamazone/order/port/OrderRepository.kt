package cat.vonblum.mamazone.order.port

import cat.vonblum.mamazone.order.aggregate.Order
import cat.vonblum.mamazone.order.aggregate.OrderId

interface OrderRepository {


    fun save(order: Order)

    fun findById(orderId: OrderId): Order

    fun deleteById(orderId: OrderId)

}