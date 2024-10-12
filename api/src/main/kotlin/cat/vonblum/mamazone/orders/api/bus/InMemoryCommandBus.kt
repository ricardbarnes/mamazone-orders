package cat.vonblum.mamazone.orders.api.bus

import cat.vonblum.mamazone.orders.shared.domain.bus.command.Command
import cat.vonblum.mamazone.orders.shared.domain.bus.command.CommandBus
import org.springframework.stereotype.Component

@Component
class InMemoryCommandBus : CommandBus {

    override fun dispatch(command: Command) {
        TODO("Not yet implemented")
    }

}