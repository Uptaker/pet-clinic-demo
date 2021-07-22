package codes.drinky.petclinicdemo.services;

import codes.drinky.petclinicdemo.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
