package cat.vonblum.mamazone.order.find

import cat.vonblum.mamazone.shared.domain.bus.query.Response

class FindOrderResponse(val id: Int, val status: String, customerId: Int, productIds: List<Int>) : Response