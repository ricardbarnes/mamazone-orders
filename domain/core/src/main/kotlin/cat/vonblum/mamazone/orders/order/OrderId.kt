package cat.vonblum.mamazone.orders.order

import cat.vonblum.mamazone.orders.shared.domain.valueobject.Id
import java.util.*

class OrderId(override val value: UUID) : Id(value)