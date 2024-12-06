package cat.vonblum.mamazone.orders.shared

import cat.vonblum.mamazone.orders.shared.domain.valueobject.Id
import java.util.UUID

class CustomerId(override val value: UUID) : Id(value)