package cat.vonblum.mamazone.customer.aggregate

import cat.vonblum.mamazone.shared.domain.valueobject.Id

class CustomerId(override val value: Int) : Id(value)