package com.domain.events.springdomainevents.listener;

import lombok.Builder;

@Builder
public record BookSold(Long id, int price) {
	
}
