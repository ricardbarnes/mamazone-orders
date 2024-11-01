package cat.vonblum.mamazone.orders.producer.mapper

import cat.vonblum.mamazone.orders.order.find.FindOrderQuery
import cat.vonblum.mamazone.orders.producer.exception.SocketQueryMapperException
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.query.SocketFindOrderQuery

class SocketQueryMapper {

    fun toDomain(message: SocketBusMessage): Any {
        when (message) {
            is SocketFindOrderQuery -> return toFindOrderQuery(message)
        }

        throw SocketQueryMapperException.becauseOf(message)
    }

    private fun toFindOrderQuery(message: SocketFindOrderQuery): FindOrderQuery =
        FindOrderQuery(message.id)

}