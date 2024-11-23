package cat.vonblum.mamazone.orders.producer.config

import cat.vonblum.mamazone.orders.order.OrderProvider
import cat.vonblum.mamazone.orders.producer.provider.InMemoryOrderProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringProducerProviderConfig {

    @Bean
    fun orderProvider(): OrderProvider {
        return InMemoryOrderProvider()
    }

}