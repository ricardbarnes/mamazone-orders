package cat.vonblum.mamazone.product

import cat.vonblum.mamazone.product.Product
import cat.vonblum.mamazone.product.ProductId

interface ProductRepository {

    fun save(product: Product)

    fun findById(productId: ProductId): Product

    fun deleteById(productId: ProductId)

}