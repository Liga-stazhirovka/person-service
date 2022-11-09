package liga.medical.person_service.core.mapper;

import liga.medical.person_service.core.dao.producer.model.MessageProducer;
import liga.medical.person_service.core.service.dto.MessageDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface MessageMapper {
    MessageProducer toProducer(MessageDto messageDto);
}