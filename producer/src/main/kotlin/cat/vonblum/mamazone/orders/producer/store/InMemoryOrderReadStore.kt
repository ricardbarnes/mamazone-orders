package cat.vonblum.mamazone.orders.producer.store

import cat.vonblum.mamazone.orders.producer.exception.InMemoryReadStoreException
import cat.vonblum.mamazone.orders.shared.domain.event.Event
import cat.vonblum.mamazone.orders.shared.domain.event.EventStore

class InMemoryOrderReadStore : EventStore {

    override fun save(event: Event) {
        throw InMemoryReadStoreException.instance()
    }

    override fun findAll(type: Class<out Event>): List<Event> {
        TODO("Not yet implemented")
    }

}