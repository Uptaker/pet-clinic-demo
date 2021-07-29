package codes.drinky.petclinicdemo.bootstrap;

import codes.drinky.petclinicdemo.model.Owner;
import codes.drinky.petclinicdemo.model.Pet;
import codes.drinky.petclinicdemo.model.PetType;
import codes.drinky.petclinicdemo.model.Vet;
import codes.drinky.petclinicdemo.services.OwnerService;
import codes.drinky.petclinicdemo.services.PetTypeService;
import codes.drinky.petclinicdemo.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);




//        Owner 1
        Owner owner1 = new Owner();
        owner1.setFirstName("Markus");
        owner1.setLastName("Tammeoja");
        owner1.setAddress("Viru 21");
        owner1.setCity("Kivioli");
        owner1.setTelephone("123123123");

        Pet markusPet = new Pet();
        markusPet.setPetType(savedCatPetType);
        markusPet.setOwner(owner1);
        markusPet.setBirthDate(LocalDate.now());
        markusPet.setName("Joy");
        owner1.getPets().add(markusPet);

        ownerService.save(owner1);

//        Owner 2
        Owner owner2 = new Owner();
        owner2.setFirstName("Siim");
        owner2.setLastName("Roov");
        owner1.setAddress("Vastriku 8");
        owner1.setCity("Tallinn");
        owner1.setTelephone("15454345");

        Pet siimPet = new Pet();
        siimPet.setPetType(savedDogPetType);
        siimPet.setOwner(owner2);
        siimPet.setBirthDate(LocalDate.now());
        siimPet.setName("fuc");
        owner2.getPets().add(siimPet);

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
