package cat.vonblum.mamazone.orders.producer.config

import cat.vonblum.mamazone.orders.producer.bus.SocketEventBus
import cat.vonblum.mamazone.orders.producer.mapper.SocketEventMapper
import cat.vonblum.mamazone.orders.shared.domain.event.EventBus
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringProducerBusConfig {

    @Bean
    fun eventBus(
        @Value("\${consumer.bus.event.socket.host}") host: String,
        @Value("\${consumer.bus.event.socket.port}") port: Int,
        socketEventMapper: SocketEventMapper
    ): EventBus {
        return SocketEventBus(
            host,
            port,
            socketEventMapper
        )
    }

}