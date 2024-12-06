package cat.vonblum.mamazone.orders.producer.config

import cat.vonblum.mamazone.orders.producer.handler.SocketBusCommandHandler
import cat.vonblum.mamazone.orders.producer.handler.SocketBusQueryHandler
import cat.vonblum.mamazone.orders.producer.mapper.SocketCommandMapper
import cat.vonblum.mamazone.orders.producer.mapper.SocketEventMapper
import cat.vonblum.mamazone.orders.producer.mapper.SocketQueryMapper
import cat.vonblum.mamazone.orders.shared.domain.handler.Handler
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusServer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringProducerSocketConfig {

    @Bean
    fun socketCommandMapper(): SocketCommandMapper {
        return SocketCommandMapper()
    }

    @Bean
    fun socketQueryMapper(): SocketQueryMapper {
        return SocketQueryMapper()
    }

    @Bean
    fun socketCommandHandler(
        @Value("\${bus.command.socket.server.port}") port: Int,
        mapper: SocketCommandMapper,
        handler: Handler,
    ): SocketBusServer {
        return SocketBusCommandHandler(
            port,
            mapper,
            handler
        )
    }

    @Bean
    fun socketQueryHandler(
        @Value("\${bus.query.socket.server.port}") port: Int,
        mapper: SocketQueryMapper,
        handler: Handler,
    ): SocketBusServer {
        return SocketBusQueryHandler(
            port,
            mapper,
            handler
        )
    }

    @Bean
    fun socketEventMapper(): SocketEventMapper {
        return SocketEventMapper()
    }

}