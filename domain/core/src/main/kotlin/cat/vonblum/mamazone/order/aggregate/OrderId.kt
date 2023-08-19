package cat.vonblum.mamazone.order.aggregate

import cat.vonblum.mamazone.shared.domain.valueobject.Id

class OrderId(override val value: Int) : Id(value)