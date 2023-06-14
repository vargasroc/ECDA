package com.Roc.service;

import com.Roc.model.Quote;

public interface QuoteService {
    Quote getRandomQuote();
    Quote getQuoteByCategory(String category);
}
