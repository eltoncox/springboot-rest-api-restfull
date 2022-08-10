package com.elton.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elton.projeto.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
