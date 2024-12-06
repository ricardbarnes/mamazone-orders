package cat.vonblum.mamazone.orders.order.find

import cat.vonblum.mamazone.orders.shared.domain.query.Response
import java.util.UUID

class FindOrderResponse(
    val id: UUID,
    val status: String,
    val customerId: UUID,
    val productIds: List<UUID>
) : Response