package cat.vonblum.mamazone.producer.provider

import cat.vonblum.mamazone.customer.aggregate.Customer
import cat.vonblum.mamazone.customer.port.CustomerProvider

class InMemoryCustomerProvider : CustomerProvider {
    override fun send(customer: Customer) {
        TODO("Not yet implemented")
    }

}