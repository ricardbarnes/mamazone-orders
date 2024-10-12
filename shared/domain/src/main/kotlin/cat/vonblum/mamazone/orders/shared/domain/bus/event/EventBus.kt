package cat.vonblum.mamazone.orders.shared.domain.bus.event

interface EventBus {

    fun publish(event: List<Event>)

}