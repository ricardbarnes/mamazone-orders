package cat.vonblum.mamazone.customer

import cat.vonblum.mamazone.shared.domain.bus.event.Event
import java.time.Instant
import java.util.UUID

class CustomerDeletedEvent(
    override val aggregateId: Int,
    override val eventId: UUID = UUID.randomUUID(),
    override val occurredOn: Instant = Instant.now()
) : Event