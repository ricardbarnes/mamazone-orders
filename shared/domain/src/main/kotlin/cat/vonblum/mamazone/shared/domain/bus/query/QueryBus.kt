package cat.vonblum.mamazone.shared.domain.bus.query

interface QueryBus {

    fun ask(query: Query): Response?

}