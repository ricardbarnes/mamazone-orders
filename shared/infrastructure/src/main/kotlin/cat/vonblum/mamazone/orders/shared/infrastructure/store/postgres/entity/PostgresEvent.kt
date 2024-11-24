package cat.vonblum.mamazone.orders.shared.infrastructure.store.postgres.entity

import jakarta.persistence.*
import java.time.Instant

@MappedSuperclass
abstract class PostgresEvent(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    open val id: Int,

    @Column(name = "aggregate_id", nullable = false)
    open val aggregateId: Int,

    @Column(name = "occurred_on", nullable = false)
    open val occurredOn: Instant

)