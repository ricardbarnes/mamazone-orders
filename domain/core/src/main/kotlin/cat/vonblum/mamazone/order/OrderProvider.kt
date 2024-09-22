package cat.vonblum.mamazone.order

interface OrderProvider {

    fun send(order: Order)

}