package com.domain.events.springdomainevents.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.domain.events.springdomainevents.domain.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public record BookUpdateListener() {

	@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
	private void archiveBook(Book bookUpdated) {
		log.info("Achive book with id {}", bookUpdated.getId());
	}
}
