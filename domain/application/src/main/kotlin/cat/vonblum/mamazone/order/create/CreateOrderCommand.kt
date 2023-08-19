package cat.vonblum.mamazone.order.create

import cat.vonblum.mamazone.shared.domain.bus.command.Command

class CreateOrderCommand(val id: Int, val status: String, val customerId: Int, val productIds: List<Int>) : Command