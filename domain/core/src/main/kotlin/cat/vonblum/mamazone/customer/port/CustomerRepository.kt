package cat.vonblum.mamazone.customer.port

import cat.vonblum.mamazone.customer.aggregate.Customer
import cat.vonblum.mamazone.customer.aggregate.CustomerId

interface CustomerRepository {

    fun save(customer: Customer)

    fun findById(customerId: CustomerId): Customer

    fun deleteById(customerId: CustomerId)

}