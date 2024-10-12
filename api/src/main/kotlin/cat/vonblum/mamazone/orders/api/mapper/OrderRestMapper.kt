package cat.vonblum.mamazone.orders.api.mapper

import cat.vonblum.mamazone.orders.order.cancel.CancelOrderCommand
import cat.vonblum.mamazone.orders.order.create.CreateOrderCommand
import cat.vonblum.mamazone.orders.order.find.FindOrderResponse
import cat.vonblum.mamazone.orders.order.update.UpdateOrderCommand
import cat.vonblum.mamazone.orders.api.model.OrderRestDto
import org.springframework.stereotype.Component

@Component
class OrderRestMapper {

    fun toDomainCreate(infraDto: OrderRestDto): CreateOrderCommand =
        CreateOrderCommand(
            infraDto.id,
            infraDto.customerId,
            infraDto.productIds
        )

    fun toDomainUpdate(infraDto: OrderRestDto): UpdateOrderCommand =
        UpdateOrderCommand(
            infraDto.id,
            infraDto.status,
            infraDto.customerId,
            infraDto.productIds
        )

    fun toDomainCancel(id: Int): CancelOrderCommand = CancelOrderCommand(id)

    fun toInfra(domainDto: FindOrderResponse): OrderRestDto = OrderRestDto(
        domainDto.id,
        domainDto.status,
        domainDto.customerId,
        domainDto.productIds
    )

}