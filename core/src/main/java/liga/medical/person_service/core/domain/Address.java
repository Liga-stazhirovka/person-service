package liga.medical.person_service.core.domain;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Long id;
    private Long contactId;
    private Long countryId;
    private String city;
    private Integer index;
    private String street;
    private String building;
    private String flat;
}
