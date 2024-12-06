package cat.vonblum.mamazone.orders.shared.domain.event

import cat.vonblum.mamazone.orders.shared.domain.valueobject.Id
import java.time.Instant

interface Event {

    val aggregateId: Id

    var id: Id

    val occurredOn: Instant

}