package cat.vonblum.mamazone.order.port

import cat.vonblum.mamazone.order.aggregate.Order
import cat.vonblum.mamazone.order.aggregate.OrderId
import cat.vonblum.mamazone.order.error.OrderNotFoundError
import kotlin.jvm.Throws

interface OrderRepository {


    fun save(order: Order)

    @Throws(OrderNotFoundError::class)
    fun findById(orderId: OrderId): Order

    @Throws(OrderNotFoundError::class)
    fun deleteById(orderId: OrderId)

}