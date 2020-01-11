package learn.java.nio.base.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Vigo on 16/11/1.
 */
public class Client {

    private Selector selector;

    public Client(String host, int port){
        try {
            selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            if (socketChannel.connect(new InetSocketAddress(host, port))){// 连接成功
                System.out.println("Client start: ");

            }else {
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        selector.select(1000);// 休眠1s
                        Set<SelectionKey> keys = selector.selectedKeys();
                        Iterator<SelectionKey> iterator = keys.iterator();
                        SelectionKey key = null;

                        while (iterator.hasNext()){
                            key = iterator.next();
                            if (key.isConnectable()){
                                handleConnect(key);
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

            private void handleConnect(SelectionKey key) throws IOException {
                if (key.isValid()){
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    if (socketChannel.finishConnect()){
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        doWrite(socketChannel);
                    }
                }
            }

            private void doWrite(SocketChannel socketChannel) throws IOException {
                System.out.print("please write msg: ");
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine() + "\r\n";//服务器换行读，需要此处添加
                message+= scanner.nextLine();

                byte[] bytes = message.getBytes();
                ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
                writeBuffer.put(bytes);
                writeBuffer.flip();
                socketChannel.write(writeBuffer);
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
                    System.out.println("client receive: " + message);

                    // 写回客户端
                    doWrite(socketChannel);
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        new Client("127.0.0.1",1234).start();
    }
}
