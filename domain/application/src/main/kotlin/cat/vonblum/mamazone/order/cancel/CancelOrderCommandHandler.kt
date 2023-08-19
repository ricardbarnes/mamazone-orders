package cat.vonblum.mamazone.order.cancel

import cat.vonblum.mamazone.order.OrderId
import cat.vonblum.mamazone.order.OrderRepository
import cat.vonblum.mamazone.shared.domain.bus.command.CommandHandler
import cat.vonblum.mamazone.shared.domain.bus.event.EventBus

class CancelOrderCommandHandler(private val orderRepository: OrderRepository, private val eventBus: EventBus) :
    CommandHandler {

    fun handle(command: CancelOrderCommand) = orderRepository.findById(OrderId(command.id)).let { order ->
        order.cancel()
        orderRepository.save(order)
        eventBus.publish(order.pullEvents())
    }

}