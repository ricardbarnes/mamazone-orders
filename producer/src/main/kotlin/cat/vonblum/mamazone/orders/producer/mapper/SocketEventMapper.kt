package cat.vonblum.mamazone.orders.producer.mapper

import cat.vonblum.mamazone.orders.order.OrderCanceledEvent
import cat.vonblum.mamazone.orders.order.OrderCreatedEvent
import cat.vonblum.mamazone.orders.order.OrderModifiedEvent
import cat.vonblum.mamazone.orders.producer.exception.SocketEventMapperException
import cat.vonblum.mamazone.orders.shared.domain.event.Event
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.SocketBusMessage
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.event.SocketOrderCanceledEvent
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.event.SocketOrderCreatedEvent
import cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket.event.SocketOrderModifiedEvent

class SocketEventMapper {

    fun toSocket(event: Event): SocketBusMessage {
        when (event) {
            is OrderCreatedEvent -> return toSocket(event)
            is OrderModifiedEvent -> return toSocket(event)
            is OrderCanceledEvent -> return toSocket(event)
        }

        throw SocketEventMapperException.becauseOf(event)
    }

    private fun toSocket(orderCreatedEvent: OrderCreatedEvent): SocketOrderCreatedEvent {
        return SocketOrderCreatedEvent(
            orderCreatedEvent.aggregateId,
            orderCreatedEvent.customerId,
            orderCreatedEvent.productIds,
            orderCreatedEvent.eventId,
            orderCreatedEvent.occurredOn
        )
    }

    private fun toSocket(orderCanceledEvent: OrderCanceledEvent): SocketOrderCanceledEvent {
        return SocketOrderCanceledEvent(
            orderCanceledEvent.aggregateId,
            orderCanceledEvent.eventId,
            orderCanceledEvent.occurredOn
        )
    }

    private fun toSocket(orderModifiedEvent: OrderModifiedEvent): SocketOrderModifiedEvent {
        return SocketOrderModifiedEvent(
            orderModifiedEvent.aggregateId,
            orderModifiedEvent.customerId,
            orderModifiedEvent.productIds,
            orderModifiedEvent.eventId,
            orderModifiedEvent.occurredOn
        )
    }

}