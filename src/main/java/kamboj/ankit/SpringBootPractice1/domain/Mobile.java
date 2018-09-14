package kamboj.ankit.SpringBootPractice1.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
@Entity
@Table(name="mobile")
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mobile_id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="cost")
    private Long cost;
}
