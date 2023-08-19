package cat.vonblum.mamazone.customer.find

import cat.vonblum.mamazone.customer.aggregate.CustomerId
import cat.vonblum.mamazone.customer.port.CustomerRepository
import cat.vonblum.mamazone.shared.domain.bus.query.QueryHandler

class FindCustomerQueryHandler(private val customerRepository: CustomerRepository) : QueryHandler {

    fun handle(query: FindCustomerQuery): FindCustomerResponse {
        val customer = customerRepository.findById(CustomerId(query.id))
        return FindCustomerResponse(
            customer.id().value,
            customer.email().value,
            customer.name().value,
            customer.surname().value
        )
    }

}