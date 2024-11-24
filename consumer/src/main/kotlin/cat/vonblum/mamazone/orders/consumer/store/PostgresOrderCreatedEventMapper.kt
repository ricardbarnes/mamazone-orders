package cat.vonblum.mamazone.orders.consumer.store

import cat.vonblum.mamazone.orders.order.OrderCreatedEvent
import cat.vonblum.mamazone.orders.shared.domain.event.Event
import cat.vonblum.mamazone.orders.shared.infrastructure.store.postgres.entity.PostgresOrderCreatedEvent
import org.springframework.stereotype.Component

@Component
class PostgresOrderCreatedEventMapper {

    fun map(event: Event): PostgresOrderCreatedEvent {
        val actual = event as OrderCreatedEvent
        return PostgresOrderCreatedEvent(
            actual.customerId,
            actual.productIds,
            actual.id,
            actual.aggregateId,
            actual.occurredOn
        )
    }

}