package liga.medical.person_service.core.dao.producer.api;

import liga.medical.person_service.core.dao.producer.model.MessageProducer;

public interface Producer {
    void sendMessage(MessageProducer message);
}
