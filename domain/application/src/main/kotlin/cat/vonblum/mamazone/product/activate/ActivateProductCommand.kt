package cat.vonblum.mamazone.product.activate

import cat.vonblum.mamazone.shared.domain.bus.command.Command

class ActivateProductCommand(val id: Int) : Command