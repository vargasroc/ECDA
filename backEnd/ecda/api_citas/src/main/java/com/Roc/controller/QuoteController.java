package com.Roc.controller;

import com.Roc.model.Quote;
import com.Roc.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/quotes")
public class QuoteController {
    private QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/random")
    public Quote getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @GetMapping("/semana/{semana}")
    public Quote getQuoteBySemana(@PathVariable Integer semana) {
        return quoteService.getQuoteBySemana(semana);
    }

    @GetMapping("/author/{author}")
    public Quote getQuoteByAuthor(@PathVariable String author) {
        return quoteService.getQuoteByAuthor(author);
    }

    @GetMapping
    public List<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }
}
