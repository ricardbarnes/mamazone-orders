package cat.vonblum.mamazone.consumer.entrypoint

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MamaZoneApp

fun main(args: Array<String>) {
    SpringApplication.run(MamaZoneApp::class.java, *args);
}