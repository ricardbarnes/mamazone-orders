package cat.vonblum.mamazone.producer.provider

import cat.vonblum.mamazone.customer.Customer
import cat.vonblum.mamazone.customer.CustomerProvider

class InMemoryCustomerProvider : CustomerProvider {
    override fun send(customer: Customer) {
        TODO("Not yet implemented")
    }

}