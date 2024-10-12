package cat.vonblum.mamazone.orders.order

import cat.vonblum.mamazone.orders.shared.domain.bus.event.Event
import java.time.Instant
import java.util.UUID

class OrderCanceledEvent(
    override val aggregateId: Int,
    override val eventId: UUID = UUID.randomUUID(),
    override val occurredOn: Instant = Instant.now()
) : Event