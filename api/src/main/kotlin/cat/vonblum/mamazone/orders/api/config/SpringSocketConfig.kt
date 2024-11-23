package cat.vonblum.mamazone.orders.api.config

import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.command.SocketCommandBus
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.command.SocketCommandMapper
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.query.SocketQueryBus
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.query.SocketQueryMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringSocketConfig {

    @Bean
    fun socketCommandMapper(): SocketCommandMapper {
        return SocketCommandMapper()
    }

    @Bean
    fun socketQueryMapper(): SocketQueryMapper {
        return SocketQueryMapper()
    }

    @Bean
    fun socketCommandBus(
        @Value("\${producer.bus.command.socket.host}") host: String,
        @Value("\${producer.bus.command.socket.port}") port: Int,
        socketCommandMapper: SocketCommandMapper
    ): SocketCommandBus {
        return SocketCommandBus(
            host,
            port,
            socketCommandMapper
        )
    }

    @Bean
    fun socketQueryBus(
        @Value("\${producer.bus.query.socket.host}") host: String,
        @Value("\${producer.bus.query.socket.port}") port: Int,
        socketQueryMapper: SocketQueryMapper
    ): SocketQueryBus {
        return SocketQueryBus(
            host,
            port,
            socketQueryMapper
        )
    }

}