package ru.sharova.TaskManager.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sharova.TaskManager.models.Person;
import ru.sharova.TaskManager.repositories.PersonRepository;

@Service
@Data
@RequiredArgsConstructor
public class PersonService {
    @Autowired
    private final PersonRepository personRepository;
    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;

    public Person register(Person person) {

        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setName(person.getName());
        person.setEmail(person.getEmail());

        Person registeredPerson = personRepository.save(person);

        return registeredPerson;
    }
}
