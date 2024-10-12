package cat.vonblum.mamazone.orders.consumer.bus

import cat.vonblum.mamazone.orders.shared.domain.bus.event.Event
import cat.vonblum.mamazone.orders.shared.domain.bus.event.EventBus

class InMemoryConsumerEventBus : EventBus {
    override fun publish(event: List<Event>) {
        TODO("Not yet implemented")
    }

}