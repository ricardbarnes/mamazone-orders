package cat.vonblum.mamazone.shared.domain.bus.command

import cat.vonblum.mamazone.shared.domain.bus.command.Command

interface CommandBus {

    fun dispatch(command: Command)

}