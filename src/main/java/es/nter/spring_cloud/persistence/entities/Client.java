package es.nter.spring_cloud.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "clients")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String phone;
    private Boolean status = true;

    @OneToMany(mappedBy = "client", orphanRemoval = true)
    private Set<ClientTrip> trips = new LinkedHashSet<>();

}
