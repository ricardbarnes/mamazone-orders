package cat.vonblum.mamazone.orders.producer.entrypoint

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("cat.vonblum.mamazone.orders.producer")
class ProducerEntrypoint

fun main(args: Array<String>) {
    SpringApplication.run(ProducerEntrypoint::class.java, *args)
}