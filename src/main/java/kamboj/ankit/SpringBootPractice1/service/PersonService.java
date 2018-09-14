package kamboj.ankit.SpringBootPractice1.service;

import java.util.List;
import java.util.Optional;
import kamboj.ankit.SpringBootPractice1.domain.Person;
import kamboj.ankit.SpringBootPractice1.dto.PersonDto;

public interface PersonService {

  List<Person> getAllPersons();

  Optional<Person> getPerson(Long id);

  Long addPerson(PersonDto personDto);

  Boolean updatePerson(PersonDto personDto);

  Boolean deletePerson(Long id);
}
