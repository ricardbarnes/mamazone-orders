package cat.vonblum.mamazone.orders.api.bus

import cat.vonblum.mamazone.orders.shared.domain.bus.query.Query
import cat.vonblum.mamazone.orders.shared.domain.bus.query.QueryBus
import cat.vonblum.mamazone.orders.shared.domain.bus.query.Response
import org.springframework.stereotype.Component

@Component
class InMemoryQueryBus : QueryBus {

    override fun ask(query: Query): Response? {
        TODO("Not yet implemented")
    }

}