package cat.vonblum.mamazone.orders.producer.exception

import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusException
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage

class SocketCommandMapperException(message: String) : SocketBusException(message) {

    companion object {

        fun becauseOf(message: SocketBusMessage): SocketCommandMapperException {
            return SocketCommandMapperException("Socket command of class \"${message::class.simpleName}\" is not recognized.")
        }

    }

}