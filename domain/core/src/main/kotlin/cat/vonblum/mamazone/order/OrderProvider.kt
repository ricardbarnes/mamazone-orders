package cat.vonblum.mamazone.order

import cat.vonblum.mamazone.order.Order

interface OrderProvider {

    fun send(order: Order)

}