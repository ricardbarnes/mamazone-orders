package cat.vonblum.mamazone.api.controller

import cat.vonblum.mamazone.api.CustomerServiceGrpc
import cat.vonblum.mamazone.api.mapper.CustomerBusGrpcMapper
import cat.vonblum.mamazone.shared.domain.bus.command.CommandBus
import cat.vonblum.mamazone.shared.domain.bus.query.QueryBus

class CustomerGrpcController(
    private val commandBus: CommandBus,
    private val queryBus: QueryBus,
    private val mapper: CustomerBusGrpcMapper
) : CustomerServiceGrpc.CustomerServiceImplBase() {
    // TODO
}