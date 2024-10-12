package cat.vonblum.mamazone.orders.shared.domain.bus.event

interface EventSubscriber {

    fun subscribedTo(): List<Any>

}