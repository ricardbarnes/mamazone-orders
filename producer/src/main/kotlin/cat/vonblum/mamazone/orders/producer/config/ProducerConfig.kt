package cat.vonblum.mamazone.orders.producer.config

import cat.vonblum.mamazone.orders.order.OrderProvider
import cat.vonblum.mamazone.orders.order.OrderRepository
import cat.vonblum.mamazone.orders.order.cancel.CancelOrderCommandHandler
import cat.vonblum.mamazone.orders.order.create.CreateOrderCommandHandler
import cat.vonblum.mamazone.orders.order.find.FindOrderQueryHandler
import cat.vonblum.mamazone.orders.order.update.UpdateOrderCommandHandler
import cat.vonblum.mamazone.orders.producer.provider.InMemoryOrderProvider
import cat.vonblum.mamazone.orders.producer.repository.InMemoryOrderReadRepository
import cat.vonblum.mamazone.orders.shared.domain.annotation.HandlerDefinition
import cat.vonblum.mamazone.orders.shared.domain.annotation.HandlerRegistry
import cat.vonblum.mamazone.orders.shared.domain.event.EventBus
import cat.vonblum.mamazone.orders.shared.domain.handler.Handler
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusServer
import cat.vonblum.mamazone.orders.producer.bus.SocketEventBus
import cat.vonblum.mamazone.orders.producer.mapper.SocketEventMapper
import cat.vonblum.mamazone.orders.producer.mapper.SocketCommandMapper
import cat.vonblum.mamazone.orders.producer.handler.SocketBusCommandHandler
import cat.vonblum.mamazone.orders.producer.handler.SocketBusQueryHandler
import cat.vonblum.mamazone.orders.producer.mapper.SocketQueryMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProducerConfig {

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
    fun handler(handlers: List<Any>): Handler {
        return Handler(handlers)
    }

    @Bean
    fun socketEventMapper(): SocketEventMapper {
        return SocketEventMapper()
    }

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

    @Bean
    fun orderRepository(): OrderRepository {
        return InMemoryOrderReadRepository()
    }

    @Bean
    fun orderProvider(): OrderProvider {
        return InMemoryOrderProvider()
    }

    @HandlerDefinition
    @Bean
    fun createOrderCommandHandler(
        orderProvider: OrderProvider,
        eventBus: EventBus,
    ): CreateOrderCommandHandler {
        return CreateOrderCommandHandler(
            orderProvider,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun updateOrderCommandHandler(
        orderRepository: OrderRepository,
        orderProvider: OrderProvider,
        eventBus: EventBus,
    ): UpdateOrderCommandHandler {
        return UpdateOrderCommandHandler(
            orderRepository,
            orderProvider,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun cancelOrderCommandHandler(
        orderRepository: OrderRepository,
        orderProvider: OrderProvider,
        eventBus: EventBus,
    ): CancelOrderCommandHandler {
        return CancelOrderCommandHandler(
            orderRepository,
            orderProvider,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun findOrderQueryHandler(orderRepository: OrderRepository): FindOrderQueryHandler {
        return FindOrderQueryHandler(orderRepository)
    }

    @HandlerRegistry
    @Bean
    fun handlers(
        createOrderCommandHandler: CreateOrderCommandHandler,
        updateOrderCommandHandler: UpdateOrderCommandHandler,
        cancelOrderCommandHandler: CancelOrderCommandHandler,
        findOrderQueryHandler: FindOrderQueryHandler,
    ): List<Any> {
        return listOf(
            createOrderCommandHandler,
            updateOrderCommandHandler,
            cancelOrderCommandHandler,
            findOrderQueryHandler,
        )
    }

}