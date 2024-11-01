package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.command

import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage

class SocketCreateOrderCommand(
    val id: Int,
    val customerId: Int,
    val productIds: List<Int>
) : SocketBusMessage()