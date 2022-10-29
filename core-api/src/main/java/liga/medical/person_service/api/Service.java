package liga.medical.person_service.api;

import java.util.List;

public interface Service<DOMAIN, ID> {
    DOMAIN getById(ID id);

    List<DOMAIN> getAll();

    DOMAIN save(DOMAIN dto);

    DOMAIN update(DOMAIN dto);

    ID delete(ID id);
}
