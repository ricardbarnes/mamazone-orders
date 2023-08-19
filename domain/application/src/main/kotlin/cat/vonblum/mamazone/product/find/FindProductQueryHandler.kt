package cat.vonblum.mamazone.product.find

import cat.vonblum.mamazone.product.ProductId
import cat.vonblum.mamazone.product.ProductRepository
import cat.vonblum.mamazone.shared.domain.bus.query.QueryHandler

class FindProductQueryHandler(private val productRepository: ProductRepository) : QueryHandler {

    fun handle(query: FindProductQuery): FindProductResponse =
        productRepository.findById(ProductId(query.id)).let { product ->
            FindProductResponse(
                product.id().value,
                product.name().value,
                product.status().name,
                mapOf(
                    "imageTitle" to product.image().title.value,
                    "imageDescription" to product.image().description.value,
                    "imagePath" to product.image().path.value
                )
            )
        }

}