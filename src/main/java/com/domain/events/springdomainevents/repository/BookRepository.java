package com.domain.events.springdomainevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.events.springdomainevents.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
