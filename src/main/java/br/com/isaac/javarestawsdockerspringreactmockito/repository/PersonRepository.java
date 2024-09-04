package br.com.isaac.javarestawsdockerspringreactmockito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.isaac.javarestawsdockerspringreactmockito.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
