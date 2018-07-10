package monk.zyli.store.console.configuration;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author lizy
 * @date 2018/06/23
 */
@Configuration
public class RocketMqConfiguration {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.rocketmq.namesrv_address}")
    private String namesrvAddr;

    @Bean
    public DefaultMQProducer defaultMQProducer() {
        DefaultMQProducer producer = new DefaultMQProducer("defaultGroup");
        producer.setNamesrvAddr(namesrvAddr);
        try {
            producer.start();
        } catch (MQClientException e) {
            logger.error("rocketMq 启动失败",e);
        }
        return producer;
    }

    @Bean
    public DefaultMQPushConsumer defaultMQPushConsumer(){

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("testConsumer");
        consumer.setNamesrvAddr(namesrvAddr);
        try {
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.subscribe("test", "*");
            consumer.setMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    for (MessageExt msg : msgs) {
                        System.out.println(new String(msg.getBody()));
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }

        return consumer;
    }

}
