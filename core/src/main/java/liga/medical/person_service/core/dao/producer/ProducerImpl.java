package liga.medical.person_service.core.dao.producer;

import liga.medical.person_service.core.dao.producer.api.Producer;
import liga.medical.person_service.core.dao.producer.model.MessageProducer;
import org.springframework.stereotype.Component;

@Component
public class ProducerImpl implements Producer {
    @Override
    public void sendMessage(MessageProducer message) {
        System.out.printf("The message is received: %s" + "\n" + "From the queue: %s" + "\n",
                message.getMessage(), message.getQueueName());
    }
}
