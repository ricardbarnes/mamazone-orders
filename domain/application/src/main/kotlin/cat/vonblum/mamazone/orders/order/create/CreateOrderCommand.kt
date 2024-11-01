package cat.vonblum.mamazone.orders.order.create

import cat.vonblum.mamazone.orders.shared.domain.command.Command

class CreateOrderCommand(
    val id: Int,
    val customerId: Int,
    val productIds: List<Int>
) : Command