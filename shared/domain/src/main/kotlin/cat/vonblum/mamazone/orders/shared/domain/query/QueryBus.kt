package cat.vonblum.mamazone.orders.shared.domain.query

interface QueryBus {

    fun ask(query: Query): Response?

}