package cat.vonblum.mamazone.orders.order.create

import cat.vonblum.mamazone.orders.shared.domain.command.Command
import java.util.*

class CreateOrderCommand(
    val id: UUID,
    val customerId: UUID,
    val productIds: List<UUID>
) : Command