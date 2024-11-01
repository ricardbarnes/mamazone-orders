package cat.vonblum.mamazone.orders.order.cancel

import cat.vonblum.mamazone.orders.order.OrderId
import cat.vonblum.mamazone.orders.order.OrderProvider
import cat.vonblum.mamazone.orders.order.OrderRepository
import cat.vonblum.mamazone.orders.shared.domain.annotation.InvokedByReflection
import cat.vonblum.mamazone.orders.shared.domain.command.CommandHandler
import cat.vonblum.mamazone.orders.shared.domain.event.EventBus

class CancelOrderCommandHandler(
    private val repository: OrderRepository,
    private val provider: OrderProvider,
    private val eventBus: EventBus
) : CommandHandler {

    @InvokedByReflection
    @Suppress("unused")
    fun handle(command: CancelOrderCommand) = repository.findById(OrderId(command.id)).let { order ->
        order.cancel()
        provider.send(order)
        eventBus.publish(order.pullEvents())
    }

}