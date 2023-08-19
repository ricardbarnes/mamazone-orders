package cat.vonblum.mamazone.product.port

import cat.vonblum.mamazone.product.aggregate.Product

interface ProductProvider {

    fun send(product: Product)

}