each task is delivered to exactly one worker
消息分发机制：轮询round-robin（不支持动态添加work，连接前已经分配好message）
            公平fair:prefetchCount设置
应答机制：ack为false开启（消息应答默认是打开）即使消费者被杀死，消息不会丢失
消息持久化：durable控制，设置消息为：MessageProperties.PERSISTENT_TEXT_PLAIN。RabbitMQ服务器崩溃，保证消息不丢失。