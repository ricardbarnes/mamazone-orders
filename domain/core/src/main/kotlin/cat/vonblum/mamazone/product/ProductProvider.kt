package cat.vonblum.mamazone.product

import cat.vonblum.mamazone.product.Product

interface ProductProvider {

    fun send(product: Product)

}