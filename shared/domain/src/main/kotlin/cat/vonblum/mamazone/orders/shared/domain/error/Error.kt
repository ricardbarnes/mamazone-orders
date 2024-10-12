package cat.vonblum.mamazone.orders.shared.domain.error

import kotlin.Exception

abstract class Error(override val message: String) : Exception() {

    fun message(): String {
        return message
    }

}