package cat.vonblum.mamazone.product.create

import cat.vonblum.mamazone.product.aggregate.Product
import cat.vonblum.mamazone.product.aggregate.ProductId
import cat.vonblum.mamazone.product.aggregate.ProductImage
import cat.vonblum.mamazone.product.aggregate.ProductImageDescription
import cat.vonblum.mamazone.product.aggregate.ProductImagePath
import cat.vonblum.mamazone.product.aggregate.ProductImageTitle
import cat.vonblum.mamazone.product.aggregate.ProductName
import cat.vonblum.mamazone.product.aggregate.ProductStatus
import cat.vonblum.mamazone.product.port.ProductRepository
import cat.vonblum.mamazone.shared.domain.bus.command.CommandHandler
import cat.vonblum.mamazone.shared.domain.bus.event.EventBus
import java.net.URI
import java.nio.file.Path

class CreateProductCommandHandler(private val productRepository: ProductRepository, private val eventBus: EventBus) :
    CommandHandler {

    fun handle(command: CreateProductCommand) = Product.create(
        ProductId(command.id), ProductName(command.name), ProductStatus.valueOf(command.status), ProductImage(
            ProductImageTitle(command.image["imageTitle"] as String),
            ProductImageDescription(command.image["imageDescription"] as String),
            ProductImagePath(Path.of(URI.create(command.image["imagePath"] as String)))
        )
    )

}