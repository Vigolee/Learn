//package learn.web.mq;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * 生产消息
// * Created by Vigo on 16/12/1.
// */
//@Component("produceMessage")
//public class ProduceMessage {
//    @Autowired
//    private AmqpTemplate template;
//
//    public void emitMessage(String key, String msg){
//        template.convertAndSend(key, msg);
//    }
//}
