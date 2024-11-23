package cat.vonblum.mamazone.orders.consumer.handler

import cat.vonblum.mamazone.orders.consumer.mapper.SocketEventMapper
import cat.vonblum.mamazone.orders.shared.domain.event.EventWriteStore
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusServer
import java.io.ObjectInputStream
import java.net.Socket

class SocketBusEventHandler(
    port: Int,
    private val mapper: SocketEventMapper,
    private val store: EventWriteStore
) : SocketBusServer(port) {

    override fun handleClient(socket: Socket) {
        socket.use {
            val input = ObjectInputStream(socket.getInputStream())
            val receivedObject = input.readObject()
            val message = receivedObject as SocketBusMessage
            val event = mapper.toDomain(message)
            store.save(event)
        }
    }

}