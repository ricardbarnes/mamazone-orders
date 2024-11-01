package cat.vonblum.mamazone.orders.producer.exception

import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusException
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage

class SocketQueryMapperException(message: String) : SocketBusException(message) {

    companion object {

        fun becauseOf(message: SocketBusMessage): SocketQueryMapperException {
            return SocketQueryMapperException("Event of type \"${message::class.simpleName}\" is unknown\"")
        }

    }

}