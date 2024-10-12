package cat.vonblum.mamazone.orders.api.model

class OrderRestDto(val id: Int, val status: String, val customerId: Int, val productIds: List<Int>)