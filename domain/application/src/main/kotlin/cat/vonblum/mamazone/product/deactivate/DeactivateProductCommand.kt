package cat.vonblum.mamazone.product.deactivate

import cat.vonblum.mamazone.shared.domain.bus.command.Command

class DeactivateProductCommand(val id: Int) : Command