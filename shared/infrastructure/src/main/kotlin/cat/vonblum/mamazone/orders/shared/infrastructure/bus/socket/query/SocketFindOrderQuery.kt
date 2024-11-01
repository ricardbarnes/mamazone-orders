package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.query

import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage

class SocketFindOrderQuery(val id: Int) : SocketBusMessage()