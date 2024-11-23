package cat.vonblum.mamazone.orders.shared.domain.event

interface EventWriteStore {

    fun save(event: Event)

}