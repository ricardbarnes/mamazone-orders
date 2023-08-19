package cat.vonblum.mamazone.order.event

import cat.vonblum.mamazone.shared.domain.bus.event.Event
import java.time.Instant
import java.util.UUID

class OrderCreatedEvent(
    override val aggregateId: Int,
    val customerId: Int,
    val productIds: List<Int>,
    override val eventId: UUID = UUID.randomUUID(),
    override val occurredOn: Instant = Instant.now()
) : Event