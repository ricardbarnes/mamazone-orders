package cat.vonblum.mamazone.orders.producer.config

import cat.vonblum.mamazone.orders.order.OrderRepository
import cat.vonblum.mamazone.orders.producer.repository.InMemoryOrderReadRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringProducerRepositoryConfig {

    @Bean
    fun orderRepository(): OrderRepository {
        return InMemoryOrderReadRepository()
    }

}