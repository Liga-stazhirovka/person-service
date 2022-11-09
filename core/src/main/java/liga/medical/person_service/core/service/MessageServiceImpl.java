package liga.medical.person_service.core.service;

import liga.medical.person_service.core.dao.producer.api.Producer;
import liga.medical.person_service.core.mapper.MessageMapper;
import liga.medical.person_service.core.service.api.MessageService;
import liga.medical.person_service.core.service.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final Producer producer;
    private final MessageMapper mapper;

    @Override
    public void handler(MessageDto message) {
        producer.sendMessage(mapper.toProducer(message));
    }
}
