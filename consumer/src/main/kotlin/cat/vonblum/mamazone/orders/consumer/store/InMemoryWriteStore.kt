package cat.vonblum.mamazone.orders.consumer.store

import cat.vonblum.mamazone.orders.shared.domain.event.Event
import cat.vonblum.mamazone.orders.shared.domain.event.EventWriteStore
import org.springframework.stereotype.Component

@Component
class InMemoryWriteStore : EventWriteStore {

    override fun save(event: Event) {
        println("STORE: saved event: $event")
    }

}