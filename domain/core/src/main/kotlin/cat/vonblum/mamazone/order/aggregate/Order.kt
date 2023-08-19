package cat.vonblum.mamazone.order.aggregate

import cat.vonblum.mamazone.customer.aggregate.CustomerId
import cat.vonblum.mamazone.order.event.OrderCanceledEvent
import cat.vonblum.mamazone.order.event.OrderCreatedEvent
import cat.vonblum.mamazone.order.event.OrderModifiedEvent
import cat.vonblum.mamazone.product.aggregate.ProductId
import cat.vonblum.mamazone.shared.domain.aggregate.AggregateRoot
import java.util.stream.Collectors

class Order(
    private val id: OrderId,
    private var status: OrderStatus,
    private var customerId: CustomerId,
    private var productIds: List<ProductId>
) : AggregateRoot() {

    companion object {

        fun create(
            id: OrderId, customerId: CustomerId, productIds: List<ProductId>
        ): Order = Order(
            id, OrderStatus.CREATED, customerId, productIds
        ).also { order ->
            order.record(
                OrderCreatedEvent(
                    id.value,
                    customerId.value,
                    productIds.stream().map { productId -> productId.value }.collect(Collectors.toList())
                )
            )
        }

    }

    private fun recordModification() = this.record(
        OrderModifiedEvent(
            this.id.value,
            this.customerId.value,
            this.productIds.stream().map { productId -> productId.value }.collect(Collectors.toList())
        )
    )

    fun id(): OrderId = this.id

    fun status(): OrderStatus = this.status

    fun customerId(): CustomerId = this.customerId

    fun productIds(): List<ProductId> = this.productIds

    fun modifyCustomer(customerId: CustomerId) = let {
        this.customerId = customerId
        this.recordModification()
    }

    fun modifyProducts(productIds: List<ProductId>) = let {
        this.productIds = productIds
        this.recordModification()
    }

    fun cancel() {
        this.status = OrderStatus.CANCELED
        this.record(
            OrderCanceledEvent(
                this.id.value
            )
        )
    }

}