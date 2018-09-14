package kamboj.ankit.SpringBootPractice1.repository;

import kamboj.ankit.SpringBootPractice1.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
