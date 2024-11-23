package cat.vonblum.mamazone.orders.consumer.config

import cat.vonblum.mamazone.orders.consumer.handler.SocketBusEventHandler
import cat.vonblum.mamazone.orders.consumer.mapper.SocketEventMapper
import cat.vonblum.mamazone.orders.consumer.store.InMemoryWriteStore
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConsumerStoreConfig {

    @Bean
    fun socketEventHandler(
        @Value("\${bus.event.socket.server.port}") port: Int,
        mapper: SocketEventMapper,
        store: InMemoryWriteStore
    ): SocketBusEventHandler {
        return SocketBusEventHandler(
            port,
            mapper,
            store
        )
    }

}