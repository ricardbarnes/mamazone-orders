package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.query

import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage

class SocketFindOrderResponse(
    val id: Int,
    val status: String,
    val customerId: Int,
    val productIds: List<Int>
) : SocketBusMessage()