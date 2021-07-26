package codes.drinky.petclinicdemo.bootstrap;

import codes.drinky.petclinicdemo.model.Owner;
import codes.drinky.petclinicdemo.model.Vet;
import codes.drinky.petclinicdemo.services.OwnerService;
import codes.drinky.petclinicdemo.services.VetService;
import codes.drinky.petclinicdemo.services.map.OwnerServiceMap;
import codes.drinky.petclinicdemo.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Markus");
        owner1.setLastName("Tammeoja");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Siim");
        owner2.setLastName("Roov");
        ownerService.save(owner2);

        System.out.println("Owners loaded..");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Hannah");
        vet1.setLastName("Hansberg");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Karl");
        vet2.setLastName("Kärbo");
        vetService.save(vet2);

        System.out.println("Vets loaded..");
    }
}
