package codes.drinky.petclinicdemo.services.map;

import codes.drinky.petclinicdemo.model.Specialty;
import codes.drinky.petclinicdemo.model.Vet;
import codes.drinky.petclinicdemo.services.SpecialtiesService;
import codes.drinky.petclinicdemo.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialtiesService specialtiesService;

    public VetMapService(SpecialtiesService specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialties().size() >0) {
            for (Specialty specialty : object.getSpecialties()) {
                if (specialty.getId() == null) {
                    Specialty savedSpecialty = specialtiesService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            }
        }

        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}
