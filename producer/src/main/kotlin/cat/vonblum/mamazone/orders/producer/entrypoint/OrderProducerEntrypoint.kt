package cat.vonblum.mamazone.orders.producer.entrypoint

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class OrderProducerEntrypoint

fun main(args: Array<String>) {
    SpringApplication.run(OrderProducerEntrypoint::class.java, *args)
}