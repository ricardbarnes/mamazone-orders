package cat.vonblum.mamazone.orders.order.find

import cat.vonblum.mamazone.orders.order.OrderId
import cat.vonblum.mamazone.orders.order.OrderRepository
import cat.vonblum.mamazone.orders.shared.domain.bus.query.QueryHandler
import java.util.stream.Collectors

class FindOrderQueryHandler(
    private val repository: OrderRepository
) : QueryHandler {

    fun handle(query: FindOrderQuery): FindOrderResponse = repository.findById(OrderId(query.id)).let { order ->
        FindOrderResponse(
            order.id().value,
            order.status().name,
            order.customerId().value,
            order.productIds().stream().map { productId -> productId.value }.collect(Collectors.toList())
        )
    }

}