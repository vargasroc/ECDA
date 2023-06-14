package com.Roc.service;


import com.Roc.model.Quote;
import com.Roc.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {
    private QuoteRepository quoteRepository;

    @Autowired
    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public Quote getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        if (quotes.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(quotes.size());
        return quotes.get(index);
    }

    @Override
    public Quote getQuoteByCategory(String category) {
        return quoteRepository.findByCategory(category);
    }
}

