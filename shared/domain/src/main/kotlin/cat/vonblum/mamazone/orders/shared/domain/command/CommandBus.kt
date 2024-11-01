package cat.vonblum.mamazone.orders.shared.domain.command

interface CommandBus {

    fun dispatch(command: Command)

}