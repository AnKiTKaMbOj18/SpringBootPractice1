package kamboj.ankit.SpringBootPractice1.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="person_id")
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany
    @JoinTable(name = "person_mobile" ,
            joinColumns = @JoinColumn(name="person_id" , referencedColumnName = "person_id") ,
            inverseJoinColumns = @JoinColumn(name = "mobile_id" , referencedColumnName = "mobile_id"))
    private List<Mobile> mobiles=new ArrayList<>();
}