package org.ebi.bess.person.query.api.repositories;

import java.util.List;

import org.ebi.bess.person.core.models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<Person, String> {
    @Query("{'$or' : [{'firstname': {$regex : ?0, $options: '1'}}, {'lastname': {$regex : ?0, $options: '1'}}, {'emailAddress': {$regex : ?0, $options: '1'}}, {'account.username': {$regex : ?0, $options: '1'}}]}")
    List<Person> findByFilterRegex(String filter);
}
