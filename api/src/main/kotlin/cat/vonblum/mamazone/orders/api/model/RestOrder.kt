package cat.vonblum.mamazone.orders.api.model

class RestOrder(
    val id: Int,
    val status: String,
    val customerId: Int,
    val productIds: List<Int>
)