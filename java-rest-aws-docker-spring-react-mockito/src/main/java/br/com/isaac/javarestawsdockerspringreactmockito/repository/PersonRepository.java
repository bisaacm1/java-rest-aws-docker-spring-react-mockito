package br.com.isaac.javarestawsdockerspringreactmockito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.isaac.javarestawsdockerspringreactmockito.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
