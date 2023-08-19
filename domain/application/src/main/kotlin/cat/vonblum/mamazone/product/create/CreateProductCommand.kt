package cat.vonblum.mamazone.product.create

import cat.vonblum.mamazone.shared.domain.bus.command.Command

class CreateProductCommand(val id: Int, val name: String, val status: String, val image: Map<String, Any>) : Command