package liga.medical.person_service.core.view.consumer.listener.api;

import liga.medical.person_service.core.view.consumer.listener.model.MessageConsumer;

public interface QueueListener {
    void listenQueue(MessageConsumer message);
}
