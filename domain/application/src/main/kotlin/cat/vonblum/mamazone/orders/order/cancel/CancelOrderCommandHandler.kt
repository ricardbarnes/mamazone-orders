package cat.vonblum.mamazone.orders.order.cancel

import cat.vonblum.mamazone.orders.order.OrderId
import cat.vonblum.mamazone.orders.order.OrderRepository
import cat.vonblum.mamazone.orders.shared.domain.bus.command.CommandHandler
import cat.vonblum.mamazone.orders.shared.domain.bus.event.EventBus

class CancelOrderCommandHandler(
    private val repository: OrderRepository,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: CancelOrderCommand) = repository.findById(OrderId(command.id)).let { order ->
        order.cancel()
        repository.save(order)
        eventBus.publish(order.pullEvents())
    }

}