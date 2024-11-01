package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket

import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.Socket

abstract class SocketBus(
    private val host: String,
    private val port: Int
) {

    protected fun send(data: SocketBusMessage) {
        Socket(host, port).use { socket ->
            val outputStream = ObjectOutputStream(socket.getOutputStream())
            outputStream.writeObject(data)
            outputStream.flush()
        }
    }

    protected fun receive(socket: Socket): SocketBusMessage? {
        val inputStream = ObjectInputStream(socket.getInputStream())
        return inputStream.readObject() as? SocketBusMessage
    }

}
