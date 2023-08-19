package cat.vonblum.mamazone.customer.modify

import cat.vonblum.mamazone.customer.CustomerEmail
import cat.vonblum.mamazone.customer.CustomerId
import cat.vonblum.mamazone.customer.CustomerName
import cat.vonblum.mamazone.customer.CustomerSurname
import cat.vonblum.mamazone.customer.CustomerRepository
import cat.vonblum.mamazone.shared.domain.bus.command.CommandHandler
import cat.vonblum.mamazone.shared.domain.bus.event.EventBus

class ModifyCustomerCommandHandler(private val customerRepository: CustomerRepository, private val eventBus: EventBus) :
    CommandHandler {

    fun handle(command: ModifyCustomerCommand) = customerRepository.findById(CustomerId(command.id)).let { customer ->
        customer.modifyEmail(CustomerEmail(command.email))
        customer.modifyName(CustomerName(command.name))
        customer.modifySurname(CustomerSurname(command.surname))
        eventBus.publish(customer.pullEvents())
    }

}