package cat.vonblum.mamazone.orders.order

import cat.vonblum.mamazone.orders.shared.CustomerId
import cat.vonblum.mamazone.orders.shared.ProductId
import cat.vonblum.mamazone.orders.shared.domain.event.Event
import cat.vonblum.mamazone.orders.shared.domain.valueobject.Id
import java.time.Instant
import java.util.*

class OrderCreatedEvent(
    override val aggregateId: OrderId,
    val customerId: CustomerId,
    val productIds: List<ProductId>,
    override var id: Id = Id(UUID.randomUUID()),
    override val occurredOn: Instant = Instant.now()
) : Event