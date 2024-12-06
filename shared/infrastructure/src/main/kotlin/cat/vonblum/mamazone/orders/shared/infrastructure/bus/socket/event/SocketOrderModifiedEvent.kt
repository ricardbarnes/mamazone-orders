package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.event

import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage
import java.time.Instant
import java.util.UUID

class SocketOrderModifiedEvent(
    val aggregateId: UUID,
    val customerId: UUID,
    val productIds: List<UUID>,
    val eventId: UUID,
    val occurredOn: Instant = Instant.now()
) : SocketBusMessage()