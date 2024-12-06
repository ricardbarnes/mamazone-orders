package cat.vonblum.mamazone.orders.api.dto

import java.util.UUID

class RestOrder(
    val id: UUID,
    val status: String,
    val customerId: UUID,
    val productIds: List<UUID>
)