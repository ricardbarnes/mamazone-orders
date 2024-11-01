package cat.vonblum.mamazone.orders.consumer.mapper

import cat.vonblum.mamazone.orders.consumer.exception.SocketEventMapperException
import cat.vonblum.mamazone.orders.order.OrderCanceledEvent
import cat.vonblum.mamazone.orders.order.OrderCreatedEvent
import cat.vonblum.mamazone.orders.order.OrderModifiedEvent
import cat.vonblum.mamazone.orders.shared.domain.event.Event
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.event.SocketOrderCanceledEvent
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.event.SocketOrderCreatedEvent
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.event.SocketOrderModifiedEvent
import org.springframework.stereotype.Component

@Component
class SocketEventMapper {

    fun toDomain(message: SocketBusMessage): Event {
        when (message) {
            is SocketOrderCreatedEvent -> return toDomain(message)
            is SocketOrderModifiedEvent -> return toDomain(message)
            is SocketOrderCanceledEvent -> return toDomain(message)
        }

        throw SocketEventMapperException.becauseOf(message)
    }

    private fun toDomain(socketEvent: SocketOrderCreatedEvent): OrderCreatedEvent {
        return OrderCreatedEvent(
            socketEvent.aggregateId,
            socketEvent.customerId,
            socketEvent.productIds,
            socketEvent.eventId,
            socketEvent.occurredOn
        )
    }

    private fun toDomain(socketEvent: SocketOrderModifiedEvent): OrderModifiedEvent {
        return OrderModifiedEvent(
            socketEvent.aggregateId,
            socketEvent.customerId,
            socketEvent.productIds,
            socketEvent.eventId,
            socketEvent.occurredOn
        )
    }

    private fun toDomain(socketEvent: SocketOrderCanceledEvent): OrderCanceledEvent {
        return OrderCanceledEvent(
            socketEvent.aggregateId,
            socketEvent.eventId,
            socketEvent.occurredOn
        )
    }

}