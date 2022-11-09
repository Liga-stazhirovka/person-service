package liga.medical.person_service.core.view.rest.controller.model.request;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestForUpdate {
    private Long id;
    private Long contactId;
    private Long countryId;
    private String city;
    private Integer index;
    private String street;
    private String building;
    private String flat;
}
