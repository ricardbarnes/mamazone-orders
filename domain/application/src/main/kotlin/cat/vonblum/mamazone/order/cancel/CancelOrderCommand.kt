package cat.vonblum.mamazone.order.cancel

import cat.vonblum.mamazone.shared.domain.bus.command.Command

class CancelOrderCommand(val id: Int) : Command