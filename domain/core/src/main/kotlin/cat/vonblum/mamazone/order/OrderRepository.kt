package cat.vonblum.mamazone.order

import cat.vonblum.mamazone.order.Order
import cat.vonblum.mamazone.order.OrderId

interface OrderRepository {


    fun save(order: Order)

    fun findById(orderId: OrderId): Order

    fun deleteById(orderId: OrderId)

}