package cat.vonblum.mamazone.orders.producer.handler

import cat.vonblum.mamazone.orders.producer.mapper.SocketQueryMapper
import cat.vonblum.mamazone.orders.shared.domain.handler.Handler
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusServer
import java.io.ObjectInputStream
import java.net.Socket

class SocketBusQueryHandler(
    port: Int,
    private val mapper: SocketQueryMapper,
    private val handler: Handler
) : SocketBusServer(port) {

    override fun handleClient(socket: Socket) {
        socket.use {
            val input = ObjectInputStream(socket.getInputStream())
            val receivedObject = input.readObject()
            val domainObject = mapper.toDomain(receivedObject as SocketBusMessage)
            handler.send(domainObject)
        }
    }

}