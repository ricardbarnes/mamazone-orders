package cat.vonblum.mamazone.orders.order

import cat.vonblum.mamazone.orders.shared.domain.event.Event
import cat.vonblum.mamazone.orders.shared.domain.valueobject.Id
import java.time.Instant
import java.util.*

class OrderCanceledEvent(
    override val aggregateId: OrderId,
    override var id: Id = Id(UUID.randomUUID()),
    override val occurredOn: Instant = Instant.now()
) : Event