package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.command

import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage

class SocketCancelOrderCommand(val id: Int) : SocketBusMessage()