package cat.vonblum.mamazone.orders.producer.exception

import cat.vonblum.mamazone.orders.shared.domain.event.Event
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusException

class SocketEventMapperException(message: String) : SocketBusException(message) {

    companion object {

        fun becauseOf(event: Event): SocketEventMapperException {
            return SocketEventMapperException("Socket event of class \"${event::class.simpleName}\" is not recognized.")
        }

    }

}