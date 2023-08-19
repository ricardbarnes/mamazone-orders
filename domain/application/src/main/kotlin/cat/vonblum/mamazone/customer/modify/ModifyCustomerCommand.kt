package cat.vonblum.mamazone.customer.modify

import cat.vonblum.mamazone.shared.domain.bus.command.Command

class ModifyCustomerCommand(
    val id: Int,
    val email: String,
    val name: String,
    val surname: String,
    val address: Map<String, Any>
) : Command