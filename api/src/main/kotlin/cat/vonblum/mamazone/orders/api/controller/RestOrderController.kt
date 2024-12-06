package cat.vonblum.mamazone.orders.api.controller

import cat.vonblum.mamazone.orders.api.mapper.RestOrderMapper
import cat.vonblum.mamazone.orders.api.dto.RestOrder
import cat.vonblum.mamazone.orders.shared.domain.command.CommandBus
import cat.vonblum.mamazone.orders.shared.domain.query.QueryBus
import cat.vonblum.mamazone.orders.shared.domain.query.Response
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/orders")
class RestOrderController(
    private val commandBus: CommandBus,
    private val queryBus: QueryBus,
    private val mapper: RestOrderMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody dto: RestOrder) =
        commandBus.dispatch(mapper.toCreateCommand(dto))

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): Response? =
        queryBus.ask(mapper.toFindQuery(id))

    @PutMapping
    fun update(@RequestBody dto: RestOrder) =
        commandBus.dispatch(mapper.toUpdateCommand(dto))

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun cancel(@PathVariable id: UUID): Unit =
        commandBus.dispatch(mapper.toCancelCommand(id))

}