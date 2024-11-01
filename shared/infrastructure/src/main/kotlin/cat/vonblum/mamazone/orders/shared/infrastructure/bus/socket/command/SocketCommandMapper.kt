package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.command

import cat.vonblum.mamazone.orders.order.cancel.CancelOrderCommand
import cat.vonblum.mamazone.orders.order.create.CreateOrderCommand
import cat.vonblum.mamazone.orders.order.update.UpdateOrderCommand
import cat.vonblum.mamazone.orders.shared.domain.command.Command
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage

class SocketCommandMapper {

    fun map(command: Command): SocketBusMessage {
        when (command) {
            is CreateOrderCommand -> return toSocketCreateOrderCommand(command)
            is CancelOrderCommand -> return toSocketCancelOrderCommand(command)
            is UpdateOrderCommand -> return toSocketUpdateOrderCommand(command)
        }

        throw IllegalArgumentException("unknown command $command")
    }

    private fun toSocketCreateOrderCommand(command: CreateOrderCommand): SocketCreateOrderCommand =
        SocketCreateOrderCommand(
            command.id,
            command.customerId,
            command.productIds
        )

    private fun toSocketCancelOrderCommand(command: CancelOrderCommand): SocketCancelOrderCommand =
        SocketCancelOrderCommand(command.id)

    private fun toSocketUpdateOrderCommand(command: UpdateOrderCommand): SocketUpdateOrderCommand =
        SocketUpdateOrderCommand(
            command.id,
            command.status,
            command.customerId,
            command.productIds
        )

}