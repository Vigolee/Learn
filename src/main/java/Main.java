import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.ArrayList;

/**
 * Created by Vigo on 17/3/21.
 */
public class Main {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>() ;
        if(str==null || str.length()==0) { return result ; }
        char[] a = str.toCharArray();
        deal(a, 0, a.length - 1, result);
        return result;
    }

    public void deal(char[] a, int start, int end, ArrayList<String> result){
        if(start == end){
            String s = "";
            for(int i = 0; i < a.length; ++i){
                s += String.valueOf(a[i]);
            }
            if (!result.contains(s)){
            result.add(s);}
        }else {
            for(int j = start; j <= end; ++j){
                char t = a[start];
                a[start] = a[j];
                a[j] = t;
                deal(a, start + 1, end, result);
                t = a[start];
                a[start] = a[j];
                a[j] = t;
            }
        }
    }

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("root.xml"));
//        factory.getBean();
//        System.out.println(new Main().Permutation("a"));
    }
}
