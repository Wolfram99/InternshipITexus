package org.example.repositories;

import org.example.Entity.Book;
import org.example.Entity.Icon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IconMongoDbRepository extends MongoRepository<Icon, String> {

    Optional<Icon> findByBookId(Integer bookId);
}
