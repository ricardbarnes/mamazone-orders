package cat.vonblum.mamazone.orders.consumer.store

import cat.vonblum.mamazone.orders.shared.infrastructure.store.postgres.entity.PostgresOrderCreatedEvent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostgresOrderCreatedEventRepository : JpaRepository<PostgresOrderCreatedEvent, Int>