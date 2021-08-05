package codes.drinky.petclinicdemo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor // for builder
//@AllArgsConstructor // for builder
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder // allows initializing in bootstrap functionally
    public Owner(Long id, String firstName, String lastName, Set<Pet> pets, String address, String city,
                 String telephone) {
        super(id, firstName, lastName);
        this.pets = pets;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

}
