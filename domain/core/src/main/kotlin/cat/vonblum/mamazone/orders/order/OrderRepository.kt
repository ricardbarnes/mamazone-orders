package cat.vonblum.mamazone.orders.order

interface OrderRepository {

    fun save(order: Order)

    fun findById(orderId: OrderId): Order

    fun deleteById(orderId: OrderId)

}