//package learn.mq;
//
//import learn.web.config.BasicTest;
//import learn.web.mq.ProduceMessage;
//import org.junit.Test;
//
//import javax.annotation.Resource;
//
///**
// * Created by Vigo on 16/12/1.
// */
//public class Producer extends BasicTest {
//    @Resource
//    private ProduceMessage produceMessage;
//
//    @Test
//    public void test_direct(){
//        produceMessage.emitMessage("queue_one_key", "hello");
//    }
//
////    public static void main(String[] args) throws InterruptedException {
////
////        ApplicationContext context =
////                new GenericXmlApplicationContext("rabbitmq-producer.xml");
////        AmqpTemplate template = context.getBean(AmqpTemplate.class);
////        //template.convertAndSend("queue_one_key", "hello!");
////        //topic模式：以foo.* routing-key为模版接收消息
////        //direct模式：接收routing-key=queue_one_key的消息
////        template.convertAndSend("queue_one_key", "hello!");
////        //fanout模式：在集群范围内的所有consumer都会收到消息
////        //template.convertAndSend("hello!");
////        System.out.println("send message:hello world!");
////    }
//}
