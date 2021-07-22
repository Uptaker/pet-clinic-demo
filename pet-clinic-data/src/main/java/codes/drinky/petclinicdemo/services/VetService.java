package codes.drinky.petclinicdemo.services;

import codes.drinky.petclinicdemo.model.Vet;

public interface VetService extends CrudService<Vet, Long> {

    Vet findByLastName(String lastName);
}
