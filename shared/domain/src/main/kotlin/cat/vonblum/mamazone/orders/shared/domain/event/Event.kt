package cat.vonblum.mamazone.orders.shared.domain.event

import java.time.Instant

interface Event {

    companion object {

        const val INITIAL_ID = -1

    }

    val aggregateId: Int

    var eventId: Int

    val occurredOn: Instant

    fun assignId(id: Int) {
        if (this.eventId != INITIAL_ID) {
            throw IllegalStateException("Event ID cannot be reassigned.")
        }

        this.eventId = id
    }

}