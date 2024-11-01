package cat.vonblum.mamazone.orders.shared.domain.aggregate

import cat.vonblum.mamazone.orders.shared.domain.event.Event

abstract class AggregateRoot {

    private var events: MutableList<Event> = mutableListOf()

    fun pullEvents(): List<Event> = events.also { events = mutableListOf() }

    fun record(event: Event) {
        events.add(event)
    }

}