package codes.drinky.petclinicdemo.services;

import codes.drinky.petclinicdemo.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findByLastName(String lastName);

    Vet findById(Vet id);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
