package liga.medical.person_service.core.view.consumer.listener.model;

import liga.medical.person_service.core.service.message_status.MessageStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageConsumer {
    private MessageStatus status;
    private String message;
}
