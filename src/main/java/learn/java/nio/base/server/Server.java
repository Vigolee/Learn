package learn.java.nio.base.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Vigo on 16/11/1.
 */
public class Server {

    private Selector selector;

    private ServerSocketChannel serverChannel;

    public Server(int port){

        try {
            selector = Selector.open();
            serverChannel = ServerSocketChannel.open();
            serverChannel.socket().bind(new InetSocketAddress(port), 1024);
            serverChannel.configureBlocking(false);//非阻塞
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);// 注册接收
            System.out.println("Server start in port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){

        new Thread(){
            boolean flag = true;
            @Override
            public void run() {
                while (flag){
                    try {
                        selector.select(1000);// 休眠1s
                        Set<SelectionKey> keys = selector.selectedKeys();
                        Iterator<SelectionKey> iterator = keys.iterator();
                        SelectionKey key = null;
                        while (iterator.hasNext()){
                            key = iterator.next();
                            if (key.isAcceptable()){
                                handleAccept(key);
                            }else if (key.isReadable()){
                                handleRead(key);
                            }else if (key.isWritable()){
                                System.out.println("-----write----");
                            }
//                            handleEvent(key);
                            iterator.remove();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            private void handleAccept(SelectionKey key) throws IOException {
                if (key.isValid()){
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = ssc.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
            }

            private void handleRead(SelectionKey key) throws IOException {
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int readBytes = socketChannel.read(byteBuffer);
                if (readBytes > 0){
                    byteBuffer.flip();// 将limit设置为position
                    byte[] bytes = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bytes);

                    String message = new String(bytes, "UTF-8");
                    System.out.println("server receive message: " + message);

                    if (message.equals("exit")){
                        flag = false;
                    }

                    // 写回客户端
                    doWrite(socketChannel,"Response: " + "123");
                }
            }

            private void doWrite(SocketChannel socketChannel, String response) throws IOException {
                byte[] bytes = response.getBytes();
                ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
                writeBuffer.put(bytes);
                writeBuffer.flip();
                socketChannel.write(writeBuffer);
            }
        }.start();
    }

    public static void main(String[] args) {
        new Server(1234).start();
    }
}
