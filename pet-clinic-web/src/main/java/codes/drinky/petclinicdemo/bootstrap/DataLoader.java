package codes.drinky.petclinicdemo.bootstrap;

import codes.drinky.petclinicdemo.model.Owner;
import codes.drinky.petclinicdemo.model.Vet;
import codes.drinky.petclinicdemo.services.OwnerService;
import codes.drinky.petclinicdemo.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Markus");
        owner1.setLastName("Tammeoja");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Siim");
        owner2.setLastName("Roov");
        ownerService.save(owner2);

        System.out.println("Owners loaded..");

        Vet vet1 = new Vet();
        vet1.setFirstName("Hannah");
        vet1.setLastName("Hansberg");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Karl");
        vet2.setLastName("Kärbo");
        vetService.save(vet2);

        System.out.println("Vets loaded..");
    }
}
