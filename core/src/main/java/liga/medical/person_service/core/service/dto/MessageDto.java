package liga.medical.person_service.core.service.dto;

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
public class MessageDto {
    private MessageStatus status;
    private String message;
    private String queueName;
}
