package cat.vonblum.mamazone.orders.order.cancel

import cat.vonblum.mamazone.orders.shared.domain.command.Command
import java.util.*

class CancelOrderCommand(val id: UUID) : Command