package com.Roc.service;

import com.Roc.model.Quote;

import java.util.List;

public interface QuoteService {
    Quote getRandomQuote();
    Quote getQuoteBySemana(Integer semana);
    Quote getQuoteByAuthor(String author);
    List<Quote> getAllQuotes();
}

