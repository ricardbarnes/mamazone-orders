package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.command

import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage
import java.util.UUID

class SocketCancelOrderCommand(val id: UUID) : SocketBusMessage()