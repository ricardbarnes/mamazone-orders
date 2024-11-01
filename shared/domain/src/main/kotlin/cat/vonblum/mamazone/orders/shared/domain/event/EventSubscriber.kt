package cat.vonblum.mamazone.orders.shared.domain.event

interface EventSubscriber {

    fun subscribedTo(): List<Any>

}