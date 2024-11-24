package cat.vonblum.mamazone.orders.producer.store

import cat.vonblum.mamazone.orders.shared.domain.event.Event
import cat.vonblum.mamazone.orders.shared.domain.event.EventReadStore

class PostgresOrderReadStore : EventReadStore {

    override fun findAll(type: Class<out Event>): List<Event> {
        TODO("Not yet implemented")
    }

}