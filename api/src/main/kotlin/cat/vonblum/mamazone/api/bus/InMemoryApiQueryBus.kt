package cat.vonblum.mamazone.api.bus

import cat.vonblum.mamazone.shared.domain.bus.query.Query
import cat.vonblum.mamazone.shared.domain.bus.query.QueryBus
import cat.vonblum.mamazone.shared.domain.bus.query.Response

class InMemoryApiQueryBus : QueryBus {
    override fun ask(query: Query): Response? {
        TODO("Not yet implemented")
    }

}