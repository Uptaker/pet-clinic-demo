package codes.drinky.petclinicdemo.repositories;

import codes.drinky.petclinicdemo.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
