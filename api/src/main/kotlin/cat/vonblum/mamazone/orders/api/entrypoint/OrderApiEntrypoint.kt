package cat.vonblum.mamazone.orders.api.entrypoint

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(
    basePackages = [
        "cat.vonblum.mamazone.orders.api",
    ]
)
class ApiEntrypoint

fun main(args: Array<String>) {
    SpringApplication.run(ApiEntrypoint::class.java, *args);
}