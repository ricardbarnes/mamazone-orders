package cat.vonblum.mamazone.orders.consumer.exception

import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage
import java.net.SocketException

class SocketEventMapperException(message: String) : SocketException(message) {

    companion object {

        fun becauseOf(message: SocketBusMessage): SocketEventMapperException {
            return SocketEventMapperException("Socket event of class \"${message::class.simpleName}\" is not recognized.")
        }

    }

}