package websocket;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.junit.Test;

import java.net.URISyntaxException;

public class SocketIoClient {


    @Test
    public void test01() throws URISyntaxException, InterruptedException {
        Socket socket = IO.socket("http://127.0.0.1:8100/chat");
        //监听new事件
        socket.emit(Socket.EVENT_CONNECT,new Emitter.Listener(){
            @Override
            public void call(Object... objects) {
                socket.emit("chat", "hi");
            }
        });
        System.out.println(socket);
    }
}
