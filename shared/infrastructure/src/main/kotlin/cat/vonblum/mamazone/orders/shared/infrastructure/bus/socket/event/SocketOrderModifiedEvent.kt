package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.event

import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage
import java.time.Instant

class SocketOrderModifiedEvent(
    val aggregateId: Int,
    val customerId: Int,
    val productIds: List<Int>,
    val eventId: Int,
    val occurredOn: Instant = Instant.now()
) : SocketBusMessage()