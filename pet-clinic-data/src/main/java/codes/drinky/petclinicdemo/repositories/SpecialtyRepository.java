package codes.drinky.petclinicdemo.repositories;

import codes.drinky.petclinicdemo.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
