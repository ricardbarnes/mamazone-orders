package cat.vonblum.mamazone.customer.port

import cat.vonblum.mamazone.customer.aggregate.Customer

interface CustomerProvider {

    fun send(customer: Customer)

}