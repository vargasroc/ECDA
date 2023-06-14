package com.Roc.service;

import com.Roc.model.Quote;

import java.util.List;

public interface QuoteService {
    Quote getRandomQuote();
    Quote getQuoteByCategory(String category);
    Quote getQuoteByAuthor(String author);
    List<Quote> getAllQuotes();
}

