package codes.drinky.petclinicdemo.bootstrap;

import codes.drinky.petclinicdemo.model.*;
import codes.drinky.petclinicdemo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

//        If nothing loaded in SQL, run bootstrap data
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("RADIOLOGY");
        Specialty savedRadiology = specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("SURGERY");
        Specialty savedSurgery = specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("DENTISTRY");
        Specialty savedDentistry = specialtiesService.save(dentistry);


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

//        Owner.builder().address("addressaaaa")
//                .city("Rakvere")
//                .firstName("NAME AA")
//                .lastName("NAME AA")
//                .telephone("5635432");

        ownerService.save(owner1);

//        Owner 2
        Owner owner2 = new Owner();
        owner2.setFirstName("Siim");
        owner2.setLastName("Roov");
        owner2.setAddress("Vastriku 8");
        owner2.setCity("Tallinn");
        owner2.setTelephone("15454345");

        Pet siimPet = new Pet();
        siimPet.setPetType(savedDogPetType);
        siimPet.setOwner(owner2);
        siimPet.setBirthDate(LocalDate.now());
        siimPet.setName("fuc");
        owner2.getPets().add(siimPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(siimPet);
        catVisit.setDescription("Feline grooming and checkup");
        catVisit.setDate(LocalDate.now());
        visitService.save(catVisit);

        System.out.println("Owners loaded..");

        Vet vet1 = new Vet();
        vet1.setFirstName("Hannah");
        vet1.setLastName("Hansberg");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Karl");
        vet2.setLastName("Kärbo");
        vet1.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Vets loaded..");
    }
}
