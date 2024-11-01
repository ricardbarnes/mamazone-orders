package cat.vonblum.mamazone.orders.shared.domain.event

interface EventBus {

    fun publish(events: List<Event>)

}