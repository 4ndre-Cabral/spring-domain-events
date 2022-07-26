package com.domain.events.springdomainevents.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.events.springdomainevents.service.BookSaleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/book-sales")
public record BookSaleControler(BookSaleService bookSaleService) {

}
