package github.javaguide;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author harrison
 * @date 2022/4/2
 */
public class SocketClient {

    public static void main(String[] args) throws Exception {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "这是一个整包!!!";
        for (int i = 0; i < 100; i++) {
            outputStream.write(message.getBytes(StandardCharsets.UTF_8));
        }
        Thread.sleep(20000);
        outputStream.close();
        socket.close();
    }

}
