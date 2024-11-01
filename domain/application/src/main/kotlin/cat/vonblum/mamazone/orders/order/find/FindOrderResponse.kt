package cat.vonblum.mamazone.orders.order.find

import cat.vonblum.mamazone.orders.shared.domain.query.Response

class FindOrderResponse(
    val id: Int,
    val status: String,
    val customerId: Int,
    val productIds: List<Int>
) : Response