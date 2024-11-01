package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.query

import cat.vonblum.mamazone.orders.shared.domain.query.Query
import cat.vonblum.mamazone.orders.shared.domain.query.Response
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage

class SocketQueryMapper {

    fun map(query: Query): SocketBusMessage {
        TODO()
    }

    fun map(message: SocketBusMessage): Response? {
        TODO()
    }

}