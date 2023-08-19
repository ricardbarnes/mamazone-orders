package cat.vonblum.mamazone.product

import cat.vonblum.mamazone.shared.domain.error.Error

class ProductNotFoundError(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(productId: ProductId): ProductNotFoundError =
            ProductNotFoundError("Product with id ${productId.value} not found.");

    }

}