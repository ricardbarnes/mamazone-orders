package cat.vonblum.mamazone.orders.producer.bus

import cat.vonblum.mamazone.orders.producer.mapper.SocketEventMapper
import cat.vonblum.mamazone.orders.shared.domain.event.Event
import cat.vonblum.mamazone.orders.shared.domain.event.EventBus
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBus

class SocketEventBus(
    host: String,
    port: Int,
    private val mapper: SocketEventMapper
) : SocketBus(host, port), EventBus {

    override fun publish(events: List<Event>) =
        events.forEach {
            send(mapper.toSocket(it))
        }

}