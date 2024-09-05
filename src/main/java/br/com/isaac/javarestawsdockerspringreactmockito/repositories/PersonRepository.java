package br.com.isaac.javarestawsdockerspringreactmockito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.isaac.javarestawsdockerspringreactmockito.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
