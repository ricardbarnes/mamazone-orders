package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.query

import cat.vonblum.mamazone.orders.shared.domain.query.Query
import cat.vonblum.mamazone.orders.shared.domain.query.QueryBus
import cat.vonblum.mamazone.orders.shared.domain.query.Response
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBus
import java.net.Socket

class SocketQueryBus(
    private val host: String,
    private val port: Int,
    private val mapper: SocketQueryMapper
) : SocketBus(host, port), QueryBus {

    override fun ask(query: Query): Response? {
        Socket(host, port).use { socket ->
            send(mapper.map(query))
            val responseJson = receive(socket)
            return responseJson?.let { response -> mapper.map(response) }
        }
    }

}
