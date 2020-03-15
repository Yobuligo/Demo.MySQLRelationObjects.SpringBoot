package com.yobuligo.DemoMySQLRelationObjects.Person;

import org.springframework.data.repository.CrudRepository;

public interface IPersonCrudRepository extends CrudRepository<Person, Long> {

}
