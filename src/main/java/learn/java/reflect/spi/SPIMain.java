package learn.java.reflect.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by Vigo on 2019/5/20.
 */
public class SPIMain {

    public static void main(String[] args) {
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = s.iterator();
        while (iterator.hasNext()){
            Search search = iterator.next();
            search.searchDoc("hello word");
        }
    }
}  