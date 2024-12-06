package cat.vonblum.mamazone.orders.order.update

import cat.vonblum.mamazone.orders.shared.domain.command.Command
import java.util.UUID

class UpdateOrderCommand(
    val id: UUID,
    val status: String,
    val customerId: UUID,
    val productIds: List<UUID>
) : Command