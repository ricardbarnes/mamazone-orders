package cat.vonblum.mamazone.product.port

import cat.vonblum.mamazone.product.aggregate.Product
import cat.vonblum.mamazone.product.aggregate.ProductId
import cat.vonblum.mamazone.product.error.ProductNotFoundError
import kotlin.jvm.Throws

interface ProductRepository {

    fun save(product: Product)

    fun findById(productId: ProductId): Product

    fun deleteById(productId: ProductId)

}