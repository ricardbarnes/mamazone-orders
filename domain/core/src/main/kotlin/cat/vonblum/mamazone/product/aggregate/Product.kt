package cat.vonblum.mamazone.product.aggregate

import cat.vonblum.mamazone.product.event.ProductActivatedEvent
import cat.vonblum.mamazone.product.event.ProductCreatedEvent
import cat.vonblum.mamazone.product.event.ProductDeactivatedEvent
import cat.vonblum.mamazone.product.event.ProductModificatedEvent
import cat.vonblum.mamazone.shared.domain.aggregate.AggregateRoot

class Product(
    private val id: ProductId,
    private var name: ProductName,
    private var status: ProductStatus,
    private var image: ProductImage,
) : AggregateRoot() {

    companion object {

        fun create(
            id: ProductId, name: ProductName, status: ProductStatus, image: ProductImage
        ): Product = Product(
            id, name, status, image
        ).also { product ->
            product.record(
                ProductCreatedEvent(
                    id.value, name.value, mapOf(
                        "imageTitle" to image.title.value,
                        "imageDescription" to image.description.value,
                        "imagePath" to image.path.value
                    )
                )
            )
        }

    }

    private fun recordModification() = this.record(
        ProductModificatedEvent(
            this.id.value, this.name.value, mapOf(
                "imageTitle" to this.image.path.value,
                "imageDescription" to this.image.title.value,
                "imagePath" to this.image.description.value
            )
        )
    )

    fun id(): ProductId = this.id

    fun name(): ProductName = this.name

    fun image(): ProductImage = this.image

    fun status(): ProductStatus = this.status

    fun modifyName(name: ProductName) = let {
        this.name = name
        this.recordModification()
    }

    fun modifyImage(image: ProductImage) = let {
        this.image = image
        this.recordModification()
    }

    fun activate() = let {
        this.status = ProductStatus.ACTIVE
        this.record(ProductActivatedEvent(this.id.value))
    }

    fun deactivate() = let {
        this.status = ProductStatus.INACTIVE
        this.record(ProductDeactivatedEvent(this.id.value))
    }

}