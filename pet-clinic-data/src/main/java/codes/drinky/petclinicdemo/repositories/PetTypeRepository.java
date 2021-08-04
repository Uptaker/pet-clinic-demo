package codes.drinky.petclinicdemo.repositories;

import codes.drinky.petclinicdemo.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
