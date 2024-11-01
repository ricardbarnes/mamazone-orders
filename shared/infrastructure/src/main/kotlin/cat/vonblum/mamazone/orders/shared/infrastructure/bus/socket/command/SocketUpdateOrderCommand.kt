package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.command

import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage

class SocketUpdateOrderCommand(
    val id: Int,
    val status: String,
    val customerId: Int,
    val productIds: List<Int>
) : SocketBusMessage()