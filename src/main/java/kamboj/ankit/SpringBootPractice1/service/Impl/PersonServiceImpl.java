package kamboj.ankit.SpringBootPractice1.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import kamboj.ankit.SpringBootPractice1.domain.Mobile;
import kamboj.ankit.SpringBootPractice1.domain.Person;
import kamboj.ankit.SpringBootPractice1.dto.PersonDto;
import kamboj.ankit.SpringBootPractice1.repository.PersonRepository;
import kamboj.ankit.SpringBootPractice1.service.MobileService;
import kamboj.ankit.SpringBootPractice1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  PersonRepository personRepository;

  @Autowired
  MobileService mobileService;

  @Override
  public List<Person> getAllPersons() {
    List<Person> persons=new ArrayList<>();
    personRepository.findAll()
        .forEach(persons::add);
    return persons;
  }

  @Override
  public Optional<Person> getPerson(Long id) {
    return personRepository.findById(id);
  }

  @Override
  public Long addPerson(PersonDto personDto) {
    Person person=Person.builder()
        .name(personDto.getName())
        .build();

    /*using for loop to get list of mobiles in person

    List<Mobile> mobiles = new ArrayList<>();
    for(MobileDto mobileDto: personDto.getMobiles()){
      Optional<Mobile> m=mobileService.getMobile(mobileDto.getId());
      mobiles.add(m.get());
    }
    person.setMobiles(mobiles);
    personRepository.save(person);
    return person.getId();
    }*/

    //using java streams

    List<Mobile> mobiles=personDto.getMobileDtos().stream()
        .map(mobileDto ->mobileService.getMobile(mobileDto.getId()).get()).collect(Collectors.toList());
    person.setMobiles(mobiles);
    personRepository.save(person);
    return person.getId();
  }

  @Override
  public Boolean updatePerson(PersonDto personDto) {
    Person person=personRepository.findById(personDto.getId()).get();
    person.setName(personDto.getName());
    List<Mobile> mobiles=personDto.getMobileDtos().stream()
        .map(mobileDto -> mobileService.getMobile(mobileDto.getId()).get()).collect(Collectors.toList());
    person.setMobiles(mobiles);
    personRepository.save(person);
    return true;
  }

  @Override
  public Boolean deletePerson(Long id) {
    personRepository.deleteById(id);
    return true;
  }
}
