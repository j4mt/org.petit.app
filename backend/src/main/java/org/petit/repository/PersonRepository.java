package org.petit.repository;

import org.petit.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Created by j4mt on 14/06/16.
 */

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByUsername(@Param(value = "username") String username);
}
