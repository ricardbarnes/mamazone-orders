package cat.vonblum.mamazone.product

interface ProductRepository {

    fun save(product: Product)

    fun findById(productId: ProductId): Product

    fun deleteById(productId: ProductId)

}