package cat.vonblum.mamazone.api.controller

import cat.vonblum.mamazone.api.mapper.OrderBusGrpcMapper
import cat.vonblum.mamazone.shared.domain.bus.command.CommandBus
import cat.vonblum.mamazone.shared.domain.bus.query.QueryBus

class OrderGrpcController(
    private val commandBus: CommandBus,
    private val queryBus: QueryBus,
    private val mapper: OrderBusGrpcMapper
) {
    // TODO
}