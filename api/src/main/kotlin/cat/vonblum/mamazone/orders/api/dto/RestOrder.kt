package cat.vonblum.mamazone.orders.api.dto

class RestOrder(
    val id: Int,
    val status: String,
    val customerId: Int,
    val productIds: List<Int>
)