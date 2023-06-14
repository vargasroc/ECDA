package com.Roc.config;

import com.Roc.repository.QuoteRepository;
import com.Roc.service.QuoteService;
import com.Roc.service.QuoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuoteConfig {
    private QuoteRepository quoteRepository;

    @Autowired
    public QuoteConfig(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Bean
    public QuoteService quoteService() {
        return new QuoteServiceImpl(quoteRepository);
    }
}

