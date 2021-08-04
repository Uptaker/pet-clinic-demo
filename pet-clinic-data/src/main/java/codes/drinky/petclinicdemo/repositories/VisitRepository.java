package codes.drinky.petclinicdemo.repositories;

import codes.drinky.petclinicdemo.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
