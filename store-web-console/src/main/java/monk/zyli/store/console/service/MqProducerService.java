package monk.zyli.store.console.service;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lizy
 * @date 2018/06/23
 */
@Service
public class MqProducerService {

    private static final Logger logger = LoggerFactory.getLogger(MqProducerService.class);

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    /**
     * 发送消息
     *
     * @param data  消息内容
     * @param topic 主题
     */
    public void sendMessage(String data, String topic) {
        byte[] messageBody = null;
        try {
            messageBody = data.getBytes(RemotingHelper.DEFAULT_CHARSET);
            Message mqMsg = new Message(topic, messageBody);
            SendResult sendResult = defaultMQProducer.send(mqMsg);
            logger.error("sendResult", sendResult);
        } catch (Exception e) {
            logger.error("发送信息出错", e);
        }


    }

}
