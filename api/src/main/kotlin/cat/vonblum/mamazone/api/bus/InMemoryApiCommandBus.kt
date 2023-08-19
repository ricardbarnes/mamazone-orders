package cat.vonblum.mamazone.api.bus

import cat.vonblum.mamazone.shared.domain.bus.command.Command
import cat.vonblum.mamazone.shared.domain.bus.command.CommandBus

class InMemoryApiCommandBus : CommandBus {
    override fun dispatch(command: Command) {
        TODO("Not yet implemented")
    }

}