package cat.vonblum.mamazone.producer.provider

import cat.vonblum.mamazone.product.aggregate.Product
import cat.vonblum.mamazone.product.port.ProductProvider

class InMemoryProductProvider : ProductProvider {

    override fun send(product: Product) {
        TODO("Not yet implemented")
    }

}