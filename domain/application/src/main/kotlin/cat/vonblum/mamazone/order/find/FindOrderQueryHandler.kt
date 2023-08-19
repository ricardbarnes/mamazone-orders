package cat.vonblum.mamazone.order.find

import cat.vonblum.mamazone.order.OrderId
import cat.vonblum.mamazone.order.OrderRepository
import cat.vonblum.mamazone.shared.domain.bus.query.QueryHandler
import java.util.stream.Collectors

class FindOrderQueryHandler(private val orderRepository: OrderRepository) : QueryHandler {

    fun handle(query: FindOrderQuery): FindOrderResponse = orderRepository.findById(OrderId(query.id)).let { order ->
        FindOrderResponse(
            order.id().value,
            order.status().name,
            order.customerId().value,
            order.productIds().stream().map { productId -> productId.value }.collect(Collectors.toList())
        )
    }

}