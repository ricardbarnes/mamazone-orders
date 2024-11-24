package cat.vonblum.mamazone.orders.consumer.store

import cat.vonblum.mamazone.orders.order.OrderCreatedEvent
import cat.vonblum.mamazone.orders.shared.domain.event.Event
import cat.vonblum.mamazone.orders.shared.domain.event.EventWriteStore
import org.springframework.stereotype.Component

@Component
class PostgresWriteStore(
    private val orderCreatedEventRepository: PostgresOrderCreatedEventRepository,
    private val orderCreatedEventMapper: PostgresOrderCreatedEventMapper
) : EventWriteStore {

    override fun save(event: Event) {
        when (event.javaClass) {
            OrderCreatedEvent::class.java -> orderCreatedEventRepository.save(orderCreatedEventMapper.map(event))
        }
    }

}