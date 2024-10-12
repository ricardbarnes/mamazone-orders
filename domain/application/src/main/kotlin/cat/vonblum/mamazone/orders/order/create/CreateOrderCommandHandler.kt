package cat.vonblum.mamazone.orders.order.create

import cat.vonblum.mamazone.orders.shared.CustomerId
import cat.vonblum.mamazone.orders.order.Order
import cat.vonblum.mamazone.orders.order.OrderId
import cat.vonblum.mamazone.orders.order.OrderRepository
import cat.vonblum.mamazone.orders.shared.ProductId
import cat.vonblum.mamazone.orders.shared.domain.bus.command.CommandHandler
import cat.vonblum.mamazone.orders.shared.domain.bus.event.EventBus
import java.util.stream.Collectors

class CreateOrderCommandHandler(
    private val repository: OrderRepository,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: CreateOrderCommand) = Order.create(
        OrderId(command.id),
        CustomerId(command.customerId),
        command.productIds.stream().map { productId -> ProductId(productId) }.collect(Collectors.toList())
    ).let { order ->
        repository.save(order)
        eventBus.publish(order.pullEvents())
    }

}