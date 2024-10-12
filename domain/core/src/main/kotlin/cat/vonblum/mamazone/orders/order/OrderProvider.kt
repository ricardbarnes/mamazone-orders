package cat.vonblum.mamazone.orders.order

interface OrderProvider {

    fun send(order: Order)

}