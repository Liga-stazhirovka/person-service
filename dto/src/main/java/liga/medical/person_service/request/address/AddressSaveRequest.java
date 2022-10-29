package liga.medical.person_service.request.address;

import javax.validation.constraints.NotNull;

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
public class AddressSaveRequest {
    @NotNull(message = "Contact ID should not be empty.")
    private Long contactId;
    @NotNull(message = "country ID should not be empty.")
    private Long countryId;
    @NotNull(message = "City should not be empty.")
    private String city;
    @NotNull(message = "Index should not be empty.")
    private Integer index;
    @NotNull(message = "Street should not be empty.")
    private String street;
    @NotNull(message = "Building should not be empty.")
    private String building;
    @NotNull(message = "Flat should not be empty.")
    private String flat;
}
