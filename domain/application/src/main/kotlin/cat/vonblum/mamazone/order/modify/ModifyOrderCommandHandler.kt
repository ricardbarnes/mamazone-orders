package cat.vonblum.mamazone.order.modify

import cat.vonblum.mamazone.customer.CustomerId
import cat.vonblum.mamazone.order.OrderId
import cat.vonblum.mamazone.order.OrderRepository
import cat.vonblum.mamazone.product.ProductId
import cat.vonblum.mamazone.shared.domain.bus.command.CommandHandler
import cat.vonblum.mamazone.shared.domain.bus.event.EventBus
import java.util.stream.Collectors

class ModifyOrderCommandHandler(private val orderRepository: OrderRepository, eventBus: EventBus) : CommandHandler {

    fun handle(command: ModifyOrderCommand) = orderRepository.findById(OrderId(command.id)).let { order ->
        order.modifyCustomer(CustomerId(command.customerId))
        order.modifyProducts(command.productIds.stream().map { productId -> ProductId(productId) }
            .collect(Collectors.toList()))
    }

}