package cat.vonblum.mamazone.customer

interface CustomerRepository {

    fun save(customer: Customer)

    fun findById(customerId: CustomerId): Customer

    fun deleteById(customerId: CustomerId)

}