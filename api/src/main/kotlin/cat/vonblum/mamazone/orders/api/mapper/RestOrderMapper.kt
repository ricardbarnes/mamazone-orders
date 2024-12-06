package cat.vonblum.mamazone.orders.api.mapper

import cat.vonblum.mamazone.orders.api.dto.RestOrder
import cat.vonblum.mamazone.orders.order.cancel.CancelOrderCommand
import cat.vonblum.mamazone.orders.order.create.CreateOrderCommand
import cat.vonblum.mamazone.orders.order.find.FindOrderQuery
import cat.vonblum.mamazone.orders.order.update.UpdateOrderCommand
import org.springframework.stereotype.Component
import java.util.UUID

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

    fun toCancelCommand(id: UUID): CancelOrderCommand =
        CancelOrderCommand(id)

    fun toFindQuery(int: UUID): FindOrderQuery =
        FindOrderQuery(int)

}