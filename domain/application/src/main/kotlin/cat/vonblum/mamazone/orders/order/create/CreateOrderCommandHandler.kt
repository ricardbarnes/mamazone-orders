package cat.vonblum.mamazone.orders.order.create

import cat.vonblum.mamazone.orders.order.Order
import cat.vonblum.mamazone.orders.order.OrderId
import cat.vonblum.mamazone.orders.order.OrderProvider
import cat.vonblum.mamazone.orders.shared.CustomerId
import cat.vonblum.mamazone.orders.shared.ProductId
import cat.vonblum.mamazone.orders.shared.domain.annotation.InvokedByReflection
import cat.vonblum.mamazone.orders.shared.domain.command.CommandHandler
import cat.vonblum.mamazone.orders.shared.domain.event.EventBus
import java.util.stream.Collectors

class CreateOrderCommandHandler(
    private val provider: OrderProvider,
    private val eventBus: EventBus
) : CommandHandler {

    @InvokedByReflection
    @Suppress("unused")
    fun handle(command: CreateOrderCommand) = Order.create(
        OrderId(command.id),
        CustomerId(command.customerId),
        command.productIds.stream().map { productId -> ProductId(productId) }.collect(Collectors.toList())
    ).let { order ->
        provider.send(order)
        eventBus.publish(order.pullEvents())
    }

}