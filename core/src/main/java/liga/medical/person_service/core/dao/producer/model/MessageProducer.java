package liga.medical.person_service.core.dao.producer.model;

import liga.medical.person_service.core.service.message_status.MessageStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageProducer {
    private MessageStatus status;
    private String message;
    private String queueName;
}

