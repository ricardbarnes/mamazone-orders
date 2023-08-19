package cat.vonblum.mamazone.customer.port

import cat.vonblum.mamazone.customer.aggregate.Customer
import cat.vonblum.mamazone.customer.aggregate.CustomerId
import cat.vonblum.mamazone.customer.error.CustomerNotFoundError
import kotlin.jvm.Throws

interface CustomerRepository {

    fun save(customer: Customer)

    @Throws(CustomerNotFoundError::class)
    fun findById(customerId: CustomerId): Customer

    @Throws(CustomerNotFoundError::class)
    fun deleteById(customerId: CustomerId)

}