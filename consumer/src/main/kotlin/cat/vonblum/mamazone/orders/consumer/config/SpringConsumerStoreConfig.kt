package cat.vonblum.mamazone.orders.consumer.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["cat.vonblum.mamazone.orders.consumer.store"])
@EntityScan(basePackages = ["cat.vonblum.mamazone.orders.shared.infrastructure.store.postgres.entity"])
class SpringConsumerStoreConfig