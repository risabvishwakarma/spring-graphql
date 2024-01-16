package com.unitral.graphql.repository;

import com.unitral.graphql.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface BookRepository extends JpaRepository< Book,Integer> {
}
