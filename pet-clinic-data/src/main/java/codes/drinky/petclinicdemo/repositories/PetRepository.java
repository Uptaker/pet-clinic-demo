package codes.drinky.petclinicdemo.repositories;

import codes.drinky.petclinicdemo.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
