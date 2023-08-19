package cat.vonblum.mamazone.customer.create

import cat.vonblum.mamazone.shared.domain.bus.command.Command

class CreateCustomerCommand(
    val id: Int, val email: String, val name: String, val surname: String, val address: Map<String, Any>
) : Command