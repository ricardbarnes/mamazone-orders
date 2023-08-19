package cat.vonblum.mamazone.product.modify

import cat.vonblum.mamazone.shared.domain.bus.command.Command

class ModifyProductCommand(val id: Int, val name: String, val status: String, val image: Map<String, Any>) : Command