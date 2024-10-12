package cat.vonblum.mamazone.orders.shared.domain.bus.command

import cat.vonblum.mamazone.orders.shared.domain.bus.command.Command

interface CommandBus {

    fun dispatch(command: Command)

}