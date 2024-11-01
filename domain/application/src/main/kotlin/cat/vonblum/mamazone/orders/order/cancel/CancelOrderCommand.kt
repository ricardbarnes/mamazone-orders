package cat.vonblum.mamazone.orders.order.cancel

import cat.vonblum.mamazone.orders.shared.domain.command.Command

class CancelOrderCommand(val id: Int) : Command