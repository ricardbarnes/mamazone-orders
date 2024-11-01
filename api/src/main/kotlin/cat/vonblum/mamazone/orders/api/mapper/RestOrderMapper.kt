package cat.vonblum.mamazone.orders.api.mapper

import cat.vonblum.mamazone.orders.api.model.RestOrder
import cat.vonblum.mamazone.orders.order.cancel.CancelOrderCommand
import cat.vonblum.mamazone.orders.order.create.CreateOrderCommand
import cat.vonblum.mamazone.orders.order.find.FindOrderQuery
import cat.vonblum.mamazone.orders.order.update.UpdateOrderCommand
import org.springframework.stereotype.Component

@Component
class RestOrderMapper {

    fun toCreateCommand(restDto: RestOrder): CreateOrderCommand =
        CreateOrderCommand(
            restDto.id,
            restDto.customerId,
            restDto.productIds
        )

    fun toUpdateCommand(restDto: RestOrder): UpdateOrderCommand =
        UpdateOrderCommand(
            restDto.id,
            restDto.status,
            restDto.customerId,
            restDto.productIds
        )

    fun toCancelCommand(id: Int): CancelOrderCommand =
        CancelOrderCommand(id)

    fun toFindQuery(int: Int): FindOrderQuery =
        FindOrderQuery(int)

}