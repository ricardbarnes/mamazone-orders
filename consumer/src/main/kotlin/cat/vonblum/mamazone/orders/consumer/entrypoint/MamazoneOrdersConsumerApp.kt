package cat.vonblum.mamazone.orders.consumer.entrypoint

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MamazoneOrdersConsumerApp

fun main(args: Array<String>) {
    SpringApplication.run(MamazoneOrdersConsumerApp::class.java, *args);
}