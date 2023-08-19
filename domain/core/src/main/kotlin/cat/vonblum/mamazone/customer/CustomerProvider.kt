package cat.vonblum.mamazone.customer

import cat.vonblum.mamazone.customer.Customer

interface CustomerProvider {

    fun send(customer: Customer)

}