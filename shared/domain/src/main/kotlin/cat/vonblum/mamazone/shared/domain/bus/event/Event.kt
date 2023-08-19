package cat.vonblum.mamazone.shared.domain.bus.event

import java.time.Instant
import java.util.UUID

interface Event {

    val aggregateId: Int

    val eventId: UUID

    val occurredOn: Instant

}