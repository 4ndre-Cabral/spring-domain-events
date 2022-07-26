package com.domain.events.springdomainevents.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public record BookSoldListener() {

	@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
	private void soldBook(BookSold bookSold) {
		log.info("Sold book with id {} and price {}", bookSold.id(), bookSold.price());
	}
}
