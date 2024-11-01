package cat.vonblum.mamazone.orders.order.update

import cat.vonblum.mamazone.orders.shared.domain.command.Command

class UpdateOrderCommand(
    val id: Int,
    val status: String,
    val customerId: Int,
    val productIds: List<Int>
) : Command