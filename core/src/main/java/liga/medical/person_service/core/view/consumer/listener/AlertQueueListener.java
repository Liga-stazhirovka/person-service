package liga.medical.person_service.core.view.consumer.listener;

import liga.medical.person_service.core.service.api.MessageService;
import liga.medical.person_service.core.service.dto.MessageDto;
import liga.medical.person_service.core.view.consumer.listener.api.QueueListener;
import liga.medical.person_service.core.view.consumer.listener.model.MessageConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlertQueueListener implements QueueListener {
    private final MessageService service;
    private final String ALERT_QUEUE = "alert_queue";

    @Override
    @RabbitListener(queues = ALERT_QUEUE)
    public void listenQueue(MessageConsumer message) {
        MessageDto messageDto = MessageDto.builder()
                .status(message.getStatus())
                .message(message.getMessage())
                .queueName(ALERT_QUEUE)
                .build();

        service.handler(messageDto);
    }
}
