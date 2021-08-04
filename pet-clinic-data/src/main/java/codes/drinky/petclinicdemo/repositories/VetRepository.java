package codes.drinky.petclinicdemo.repositories;

import codes.drinky.petclinicdemo.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
