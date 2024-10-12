package cat.vonblum.mamazone.orders.order.update

import cat.vonblum.mamazone.orders.shared.CustomerId
import cat.vonblum.mamazone.orders.order.OrderId
import cat.vonblum.mamazone.orders.order.OrderRepository
import cat.vonblum.mamazone.orders.shared.ProductId
import cat.vonblum.mamazone.orders.shared.domain.bus.command.CommandHandler
import cat.vonblum.mamazone.orders.shared.domain.bus.event.EventBus
import java.util.stream.Collectors

class UpdateOrderCommandHandler(
    private val orderRepository: OrderRepository,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: UpdateOrderCommand) = orderRepository.findById(OrderId(command.id)).let { order ->
        order.modifyCustomer(CustomerId(command.customerId))
        order.modifyProducts(command.productIds.stream().map { productId -> ProductId(productId) }
            .collect(Collectors.toList()))
        eventBus.publish(order.pullEvents())
    }

}