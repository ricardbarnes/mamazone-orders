package cat.vonblum.mamazone.api.entrypoint

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MamazoneApp

fun main(args: Array<String>) {
    SpringApplication.run(MamazoneApp::class.java, *args);
}