package com.domain.events.springdomainevents.service;

import org.springframework.stereotype.Service;

import com.domain.events.springdomainevents.repository.BookSaleRepository;

@Service
public record BookSaleService(BookSaleRepository bookRepository) {

}
