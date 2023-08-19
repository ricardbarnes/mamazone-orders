package cat.vonblum.mamazone.customer.create

import cat.vonblum.mamazone.customer.aggregate.Customer
import cat.vonblum.mamazone.customer.aggregate.CustomerAddress
import cat.vonblum.mamazone.customer.aggregate.CustomerAddressCountry
import cat.vonblum.mamazone.customer.aggregate.CustomerAddressLine
import cat.vonblum.mamazone.customer.aggregate.CustomerAddressPostcode
import cat.vonblum.mamazone.customer.aggregate.CustomerEmail
import cat.vonblum.mamazone.customer.aggregate.CustomerId
import cat.vonblum.mamazone.customer.aggregate.CustomerName
import cat.vonblum.mamazone.customer.aggregate.CustomerSurname
import cat.vonblum.mamazone.customer.port.CustomerRepository
import cat.vonblum.mamazone.shared.domain.bus.command.CommandHandler
import cat.vonblum.mamazone.shared.domain.bus.event.EventBus

class CreateCustomerCommandHandler(private val customerRepository: CustomerRepository, private val eventBus: EventBus) :
    CommandHandler {

    fun handle(command: CreateCustomerCommand) = Customer.create(
        CustomerId(command.id),
        CustomerEmail(command.email),
        CustomerName(command.name),
        CustomerSurname(command.surname),
        CustomerAddress(
            CustomerAddressLine(command.address["addressLine"] as String),
            CustomerAddressPostcode(command.address["addressPostcode"] as String),
            CustomerAddressCountry(command.address["addressCountry"] as String)
        )
    ).also { customer ->
        customerRepository.save(customer)
        eventBus.publish(customer.pullEvents())
    }

}