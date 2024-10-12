package cat.vonblum.mamazone.orders.shared.domain.bus.query

interface QueryBus {

    fun ask(query: Query): Response?

}