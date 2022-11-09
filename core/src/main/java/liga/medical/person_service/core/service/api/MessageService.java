package liga.medical.person_service.core.service.api;

import liga.medical.person_service.core.service.dto.MessageDto;

public interface MessageService {
    void handler(MessageDto message);
}
