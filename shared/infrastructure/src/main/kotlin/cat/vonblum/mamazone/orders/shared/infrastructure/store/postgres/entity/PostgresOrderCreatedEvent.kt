package cat.vonblum.mamazone.orders.shared.infrastructure.store.postgres.entity

import cat.vonblum.mamazone.orders.shared.infrastructure.store.postgres.PostgresIntListToStringConverter
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "order_created_event")
data class PostgresOrderCreatedEvent(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int,

    @Column(name = "aggregate_id", nullable = false)
    val aggregateId: Int,

    @Column(name = "customer_id", nullable = false)
    val customerId: Int,

    @Column(name = "product_ids", nullable = false)
    @Convert(converter = PostgresIntListToStringConverter::class)
    val productIds: List<Int>,

    @Column(name = "occurred_on", nullable = false)
    val occurredOn: Instant

) {

    constructor() : this(
        id = 0,
        aggregateId = 0,
        customerId = 0,
        productIds = emptyList(),
        occurredOn = Instant.now()
    )

}