package cat.vonblum.mamazone.api.mapper

import cat.vonblum.mamazone.shared.domain.bus.command.Command
import cat.vonblum.mamazone.shared.domain.bus.query.Query
import cat.vonblum.mamazone.shared.domain.bus.query.Response

interface CustomerBusGrpcMapper {

    fun fromQuery(response: Response): Any

    fun toCommand(body: Any): Command

    fun toQuery(body: Any): Query

}