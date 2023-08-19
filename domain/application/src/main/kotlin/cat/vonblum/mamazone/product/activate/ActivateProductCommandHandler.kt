package cat.vonblum.mamazone.product.activate

import cat.vonblum.mamazone.product.aggregate.ProductId
import cat.vonblum.mamazone.product.port.ProductRepository
import cat.vonblum.mamazone.shared.domain.bus.command.CommandHandler
import cat.vonblum.mamazone.shared.domain.bus.event.EventBus

class ActivateProductCommandHandler(private val productRepository: ProductRepository, private val eventBus: EventBus) :
    CommandHandler {

    fun handle(command: ActivateProductCommand) = productRepository.findById(ProductId(command.id)).let { product ->
        product.activate()
        productRepository.save(product)
        eventBus.publish(product.pullEvents())
    }

}