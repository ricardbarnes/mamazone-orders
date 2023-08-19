package cat.vonblum.mamazone.customer.create

import cat.vonblum.mamazone.customer.Customer
import cat.vonblum.mamazone.customer.CustomerAddress
import cat.vonblum.mamazone.customer.CustomerAddressCountry
import cat.vonblum.mamazone.customer.CustomerAddressLine
import cat.vonblum.mamazone.customer.CustomerAddressPostcode
import cat.vonblum.mamazone.customer.CustomerEmail
import cat.vonblum.mamazone.customer.CustomerId
import cat.vonblum.mamazone.customer.CustomerName
import cat.vonblum.mamazone.customer.CustomerSurname
import cat.vonblum.mamazone.customer.CustomerRepository
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