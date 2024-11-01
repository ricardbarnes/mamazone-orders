package cat.vonblum.mamazone.orders.consumer.store

import cat.vonblum.mamazone.orders.consumer.exception.InMemoryWriteStoreException
import cat.vonblum.mamazone.orders.shared.domain.event.Event
import cat.vonblum.mamazone.orders.shared.domain.event.EventStore
import org.springframework.stereotype.Component

@Component
class InMemoryWriteStore : EventStore {

    override fun save(event: Event) {
        println("STORE: saved event: $event")
    }

    override fun findAll(type: Class<out Event>): List<Event> {
        throw InMemoryWriteStoreException.instance()
    }

}