package cat.vonblum.mamazone.consumer.bus

import cat.vonblum.mamazone.shared.domain.bus.event.Event
import cat.vonblum.mamazone.shared.domain.bus.event.EventBus

class InMemoryConsumerEventBus : EventBus {
    override fun publish(event: List<Event>) {
        TODO("Not yet implemented")
    }

}