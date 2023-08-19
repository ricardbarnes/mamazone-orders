package cat.vonblum.mamazone.order.modify

import cat.vonblum.mamazone.shared.domain.bus.command.Command

class ModifyOrderCommand(val id: Int, val customerId: Int, val productIds: List<Int>) : Command