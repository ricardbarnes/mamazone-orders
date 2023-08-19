package cat.vonblum.mamazone.shared.domain.bus.event

interface EventSubscriber {

    fun subscribedTo(): List<Any>

}