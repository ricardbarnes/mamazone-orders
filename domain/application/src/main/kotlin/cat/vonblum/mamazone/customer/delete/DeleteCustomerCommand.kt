package cat.vonblum.mamazone.customer.delete

import cat.vonblum.mamazone.shared.domain.bus.command.Command

class DeleteCustomerCommand(val id: Int) : Command