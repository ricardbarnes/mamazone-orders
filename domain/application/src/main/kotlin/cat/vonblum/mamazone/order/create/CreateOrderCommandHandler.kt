package cat.vonblum.mamazone.order.create

import cat.vonblum.mamazone.customer.CustomerId
import cat.vonblum.mamazone.order.Order
import cat.vonblum.mamazone.order.OrderId
import cat.vonblum.mamazone.order.OrderRepository
import cat.vonblum.mamazone.product.ProductId
import cat.vonblum.mamazone.shared.domain.bus.command.CommandHandler
import cat.vonblum.mamazone.shared.domain.bus.event.EventBus
import java.util.stream.Collectors

class CreateOrderCommandHandler(private val orderRepository: OrderRepository, private val eventBus: EventBus) :
    CommandHandler {

    fun handle(command: CreateOrderCommand) = Order.create(
        OrderId(command.id),
        CustomerId(command.customerId),
        command.productIds.stream().map { productId -> ProductId(productId) }.collect(Collectors.toList())
    ).let { order ->
        orderRepository.save(order)
        eventBus.publish(order.pullEvents())
    }

}