package cat.vonblum.mamazone.orders.shared.infrastructure.bus.socket

import jakarta.annotation.PostConstruct
import java.net.ServerSocket

abstract class SocketBusServer(private val port: Int) {

    @PostConstruct
    fun startServer() {
        Thread {
            ServerSocket(port).use { serverSocket ->
                println("Socket server started on port $port")
                while (true) {
                    val socket = serverSocket.accept()
                    handleClient(socket)
                }
            }
        }.start()
    }

    protected abstract fun handleClient(socket: java.net.Socket)

}
