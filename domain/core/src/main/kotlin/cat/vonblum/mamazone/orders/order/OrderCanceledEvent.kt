package cat.vonblum.mamazone.orders.order

import cat.vonblum.mamazone.orders.shared.domain.event.Event
import java.time.Instant

class OrderCanceledEvent(
    override val aggregateId: Int,
    override var id: Int = Event.INITIAL_ID,
    override val occurredOn: Instant = Instant.now()
) : Event