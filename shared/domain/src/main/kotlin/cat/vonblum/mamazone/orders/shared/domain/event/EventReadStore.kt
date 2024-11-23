package cat.vonblum.mamazone.orders.shared.domain.event

interface EventReadStore {

    fun findAll(type: Class<out Event>): List<Event>

}