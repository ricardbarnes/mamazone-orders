package cat.vonblum.mamazone.shared.domain.bus.event

import cat.vonblum.mamazone.shared.domain.bus.event.Event

interface EventBus {

    fun publish(event: List<Event>)

}