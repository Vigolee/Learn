package learn.java.classloader;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 自定义Classloader，重写findClass方法，获取类
 * Created by Vigo on 16/5/29.
 */
public class VigoClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("********");
        String classPath = VigoClassLoader.class.getResource("/").getPath(); //得到classpath
        String fileName = name.replace(".", "/") + ".class" ;
        System.out.println(fileName);
        File classFile = new File(classPath , fileName);
        if(!classFile.exists()){
            throw new ClassNotFoundException(classFile.getPath() + " 不存在") ;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream() ;
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        FileInputStream fis = null ;
        FileChannel fc = null ;
        try {
            fis = new FileInputStream(classFile);
            fc = fis.getChannel() ;
            while (fc.read(byteBuffer) > 0) {
                byteBuffer.flip() ;
                bos.write(byteBuffer.array(),0 , byteBuffer.limit()) ;
                byteBuffer.clear() ;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fis.close() ;
                fc.close() ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.defineClass(name, bos.toByteArray(),0, bos.toByteArray().length) ;
    }

    public static void main(String[] args) {
        String classPath = VigoClassLoader.class.getResource("/").getPath(); //得到classpath
        String fileName = "hot.person".replace(".", "/") + ".class" ;
        System.out.println(fileName);
    }
}
