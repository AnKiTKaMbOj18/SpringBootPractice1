package kamboj.ankit.SpringBootPractice1.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import kamboj.ankit.SpringBootPractice1.domain.Mobile;
import kamboj.ankit.SpringBootPractice1.domain.Person;
import kamboj.ankit.SpringBootPractice1.dto.MobileDto;
import kamboj.ankit.SpringBootPractice1.dto.PersonDto;
import kamboj.ankit.SpringBootPractice1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@CrossOrigin(origins = "http://localhost:4400", maxAge = 3600,
        allowCredentials = "true",
        methods = { RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,
                RequestMethod.OPTIONS})*/
/*@CrossOrigin(origins = "*", maxAge = 3600)*/

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  PersonService personService;

  private static final String OK = "OK";

  @GetMapping("/")
  public List<PersonDto> getAllPersons() {
    return personService.getAllPersons().stream().map(this::buildPersonDto)
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public PersonDto getPerson(@PathVariable Long id) {
    Optional<Person> person = personService.getPerson(id);
    return buildPersonDto(person.get());
  }

  @PostMapping
  public Long addPerson(@RequestBody PersonDto personDto) {
    return personService.addPerson(personDto);
  }

  @PutMapping
  public String updateUser(@RequestBody PersonDto personDto) {
    personService.updatePerson(personDto);
    return OK;
  }

  public String deletePerson(@PathVariable Long id) {
    personService.deletePerson(id);
    return OK;
  }

  public PersonDto buildPersonDto(Person person) {
    return PersonDto.builder()
        .id(person.getId())
        .name(person.getName())
        .mobileDtos(person.getMobiles().stream().map(
            mobile -> MobileDto.builder().cost(mobile.getCost()).id(mobile.getId())
                .name(mobile.getName()).build()).collect(Collectors.toList()))
        .build();
  }
}