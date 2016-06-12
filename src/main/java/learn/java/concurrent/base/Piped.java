package learn.java.concurrent.base;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 通过管道进行线程通信
 * Created by Vigo on 16/5/31.
 */
public class Piped {

    public static void main(String[] args) {
        /** 基于字符 */
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();

        // 连接输入/输出流
        try {
            out.connect(in); //!!!!必须有!!!
            Thread printThread = new Thread(new Print(in), "PrintThread");
            printThread.start();

            int receive = 0;
            byte[] bytes = new byte[512];
            while ((receive = System.in.read(bytes)) != -1){
                String msg = new String(bytes,0,receive);
                out.write(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Print implements Runnable{

        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        public void run() {
            int receive = 0;
            try {
                char[] chars = new char[512];
                while ((receive = in.read(chars)) != -1) {
                    String msg = new String(chars,0,receive);
                    System.out.println(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } {

            }
        }
    }
}

