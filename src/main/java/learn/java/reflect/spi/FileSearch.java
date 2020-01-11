package learn.java.reflect.spi;

import java.util.List;

/**
 * Created by Vigo on 2019/5/20.
 */
public class FileSearch implements Search{
    public List<String> searchDoc(String keyword) {
        System.out.println("file search:" + keyword);
        return null;
    }
}