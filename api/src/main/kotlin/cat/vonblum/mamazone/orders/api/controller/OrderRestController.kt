package cat.vonblum.mamazone.orders.api.controller

import cat.vonblum.mamazone.orders.api.mapper.OrderRestMapper
import cat.vonblum.mamazone.orders.api.model.OrderRestDto
import cat.vonblum.mamazone.orders.shared.domain.bus.command.CommandBus
import cat.vonblum.mamazone.orders.shared.domain.bus.query.QueryBus
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderRestController(
    private val commandBus: CommandBus,
    private val queryBus: QueryBus,
    private val mapper: OrderRestMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody infraDto: OrderRestDto): OrderRestDto =
        TODO()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): OrderRestDto =
        TODO()

    @PutMapping
    fun update(@RequestBody infraDto: OrderRestDto): OrderRestDto =
        TODO()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun cancel(@PathVariable id: Int): Nothing =
        TODO()

}