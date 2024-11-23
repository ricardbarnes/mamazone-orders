package cat.vonblum.mamazone.orders.producer.config

import cat.vonblum.mamazone.orders.order.OrderProvider
import cat.vonblum.mamazone.orders.order.OrderRepository
import cat.vonblum.mamazone.orders.order.cancel.CancelOrderCommandHandler
import cat.vonblum.mamazone.orders.order.create.CreateOrderCommandHandler
import cat.vonblum.mamazone.orders.order.find.FindOrderQueryHandler
import cat.vonblum.mamazone.orders.order.update.UpdateOrderCommandHandler
import cat.vonblum.mamazone.orders.shared.domain.annotation.HandlerDefinition
import cat.vonblum.mamazone.orders.shared.domain.annotation.HandlerRegistry
import cat.vonblum.mamazone.orders.shared.domain.event.EventBus
import cat.vonblum.mamazone.orders.shared.domain.handler.Handler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringProducerHandlerConfig {

    @Bean
    fun handler(handlers: List<Any>): Handler {
        return Handler(handlers)
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

}