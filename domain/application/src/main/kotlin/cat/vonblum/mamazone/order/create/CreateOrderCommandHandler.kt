package cat.vonblum.mamazone.order.create

import cat.vonblum.mamazone.customer.aggregate.CustomerId
import cat.vonblum.mamazone.order.aggregate.Order
import cat.vonblum.mamazone.order.aggregate.OrderId
import cat.vonblum.mamazone.order.port.OrderRepository
import cat.vonblum.mamazone.product.aggregate.ProductId
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