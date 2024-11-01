package cat.vonblum.mamazone.orders.producer.mapper

import cat.vonblum.mamazone.orders.order.cancel.CancelOrderCommand
import cat.vonblum.mamazone.orders.order.create.CreateOrderCommand
import cat.vonblum.mamazone.orders.order.update.UpdateOrderCommand
import cat.vonblum.mamazone.orders.producer.exception.SocketCommandMapperException
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.command.SocketCancelOrderCommand
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.command.SocketCreateOrderCommand
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.command.SocketUpdateOrderCommand

class SocketCommandMapper {

    fun toDomain(message: SocketBusMessage): Any {
        when (message) {
            is SocketCreateOrderCommand -> return toCreateOrderCommand(message)
            is SocketCancelOrderCommand -> return toCancelOrderCommand(message)
            is SocketUpdateOrderCommand -> return toUpdateOrderCommand(message)
        }

        throw SocketCommandMapperException.becauseOf(message)
    }

    private fun toCreateOrderCommand(message: SocketCreateOrderCommand): CreateOrderCommand {
        return CreateOrderCommand(
            message.id,
            message.customerId,
            message.productIds
        )
    }

    private fun toCancelOrderCommand(message: SocketCancelOrderCommand): CancelOrderCommand {
        return CancelOrderCommand(message.id)
    }

    private fun toUpdateOrderCommand(message: SocketUpdateOrderCommand): UpdateOrderCommand {
        return UpdateOrderCommand(
            message.id,
            message.status,
            message.customerId,
            message.productIds
        )
    }

}