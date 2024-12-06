package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.query

import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage
import java.util.UUID

class SocketFindOrderQuery(val id: UUID) : SocketBusMessage()