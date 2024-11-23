package cat.vonblum.mamazone.orders.consumer.entrypoint

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("cat.vonblum.mamazone.orders.consumer")
class SpringConsumerEntrypoint

fun main(args: Array<String>) {
    SpringApplication.run(SpringConsumerEntrypoint::class.java, *args);
}