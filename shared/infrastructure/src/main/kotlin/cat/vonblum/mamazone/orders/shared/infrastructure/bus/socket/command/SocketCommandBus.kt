package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.command

import cat.vonblum.mamazone.orders.shared.domain.command.Command
import cat.vonblum.mamazone.orders.shared.domain.command.CommandBus
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBus

class SocketCommandBus(
    host: String,
    port: Int,
    private val mapper: SocketCommandMapper
) : SocketBus(host, port), CommandBus {

    override fun dispatch(command: Command) =
        send(mapper.map(command))

}
