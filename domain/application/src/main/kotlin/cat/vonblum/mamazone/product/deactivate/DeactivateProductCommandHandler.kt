package cat.vonblum.mamazone.product.deactivate

import cat.vonblum.mamazone.product.ProductId
import cat.vonblum.mamazone.product.ProductRepository
import cat.vonblum.mamazone.shared.domain.bus.command.CommandHandler
import cat.vonblum.mamazone.shared.domain.bus.event.EventBus

class DeactivateProductCommandHandler(
    private val productRepository: ProductRepository,
    private val eventBus: EventBus
) :
    CommandHandler {

    fun handle(command: DeactivateProductCommand) = productRepository.findById(ProductId(command.id)).let { product ->
        product.deactivate()
        productRepository.save(product)
        eventBus.publish(product.pullEvents())
    }

}