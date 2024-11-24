package cat.vonblum.mamazone.orders.order

import cat.vonblum.mamazone.orders.shared.domain.event.Event
import java.time.Instant

class OrderModifiedEvent(
    override val aggregateId: Int,
    val customerId: Int,
    val productIds: List<Int>,
    override var id: Int = Event.INITIAL_ID,
    override val occurredOn: Instant = Instant.now()
) : Event