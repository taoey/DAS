package websocket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class WebsocketClient {


    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        WebSocketClient webSocketClient = new WebSocketClient(new URI("ws://localhost:8080/echo"),new Draft_6455()){

            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                System.out.println("连接成功");
            }

            @Override
            public void onMessage(String s) {

            }

            @Override
            public void onClose(int i, String s, boolean b) {

            }

            @Override
            public void onError(Exception e) {

            }
        };
        webSocketClient.connect();
        Thread.sleep(1000*2);  // 等待TCP进行连接
        webSocketClient.send("hello");
        webSocketClient.close();
    }
}
