package liga.medical.person_service.dto;

import lombok.Getter;
import lombok.Builder;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;
    private ContactDto contactEntity;
    private Long countryId;
    private String city;
    private Integer index;
    private String street;
    private String building;
    private String flat;
}
