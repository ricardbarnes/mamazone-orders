package cat.vonblum.mamazone.order.port

import cat.vonblum.mamazone.order.aggregate.Order

interface OrderProvider {

    fun send(order: Order)

}