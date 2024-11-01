package cat.vonblum.mamazone.orders.order.update

import cat.vonblum.mamazone.orders.shared.CustomerId
import cat.vonblum.mamazone.orders.order.OrderId
import cat.vonblum.mamazone.orders.order.OrderProvider
import cat.vonblum.mamazone.orders.order.OrderRepository
import cat.vonblum.mamazone.orders.shared.ProductId
import cat.vonblum.mamazone.orders.shared.domain.annotation.InvokedByReflection
import cat.vonblum.mamazone.orders.shared.domain.command.CommandHandler
import cat.vonblum.mamazone.orders.shared.domain.event.EventBus
import java.util.stream.Collectors

class UpdateOrderCommandHandler(
    private val repository: OrderRepository,
    private val provider: OrderProvider,
    private val eventBus: EventBus
) : CommandHandler {

    @InvokedByReflection
    @Suppress("unused")
    fun handle(command: UpdateOrderCommand) = repository.findById(OrderId(command.id)).let { order ->
        order.modifyCustomer(CustomerId(command.customerId))
        order.modifyProducts(command.productIds.stream().map { productId -> ProductId(productId) }
            .collect(Collectors.toList()))
        provider.send(order)
        eventBus.publish(order.pullEvents())
    }

}