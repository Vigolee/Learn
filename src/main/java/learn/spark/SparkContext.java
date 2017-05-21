package learn.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

/**
 * Created by Vigo on 17/4/13.
 */
public class SparkContext {

    public static void main(String[] args) {
        String logFile = "/Users/lwg/broker.log";
        SparkConf conf = new SparkConf().setMaster("local").setAppName("My App");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> logData = sc.textFile(logFile).cache();

        long numAS = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) throws Exception {
                return s.contains("a");
            }
        }).count();
        System.out.println(numAS);
        sc.stop();
    }
}
