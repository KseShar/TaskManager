package ru.sharova.TaskManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sharova.TaskManager.models.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
