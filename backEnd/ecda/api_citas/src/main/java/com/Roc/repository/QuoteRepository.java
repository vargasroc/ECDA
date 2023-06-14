package com.Roc.repository;


import com.Roc.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    Quote findByCategory(String category);
    Quote findByAuthor(String author);
}

