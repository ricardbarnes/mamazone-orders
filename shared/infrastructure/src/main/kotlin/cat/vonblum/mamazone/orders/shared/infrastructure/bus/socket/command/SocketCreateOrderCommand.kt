package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.command

import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage
import java.util.UUID

class SocketCreateOrderCommand(
    val id: UUID,
    val customerId: UUID,
    val productIds: List<UUID>
) : SocketBusMessage()