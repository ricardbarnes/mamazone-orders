package cat.vonblum.mamazone.orders.shared.domain.event

interface EventStore {

    fun save(event: Event)

    fun findAll(type: Class<out Event>): List<Event>

}