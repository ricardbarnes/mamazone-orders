package cat.vonblum.mamazone.orders.shared.infrastructure.store.postgres.entity

import cat.vonblum.mamazone.orders.shared.infrastructure.store.postgres.PostgresIntListToStringConverter
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "order_created_events")
data class PostgresOrderCreatedEvent(

    @Column(name = "customer_id", nullable = false)
    val customerId: Int,

    @Column(name = "product_ids", nullable = false)
    @Convert(converter = PostgresIntListToStringConverter::class)
    val productIds: List<Int>,

    override val id: Int,
    override val aggregateId: Int,
    override val occurredOn: Instant = Instant.now()
) : PostgresEvent(
    id,
    aggregateId,
    occurredOn
) {

    constructor() : this(
        customerId = 0,
        productIds = emptyList(),
        id = 0,
        aggregateId = 0,
        occurredOn = Instant.now()
    )

}