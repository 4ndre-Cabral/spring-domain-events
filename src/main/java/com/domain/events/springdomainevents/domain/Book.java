package com.domain.events.springdomainevents.domain;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.domain.AbstractAggregateRoot;

import com.domain.events.springdomainevents.listener.BookSold;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class Book extends AbstractAggregateRoot<Book> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private OffsetDateTime dateCreated;
	
	private OffsetDateTime lastDateUpdated;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Author author;
	
	private int price;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL)
	private List<BookSale> bookSales = new ArrayList<>();
	
	public void register() {
		this.dateCreated = OffsetDateTime.now();
		this.lastDateUpdated = OffsetDateTime.now();
	}
	
	public void sell() {
		final var bookSale = new BookSale();
		bookSale.setBook(this);
		bookSale.setDateSold(OffsetDateTime.now());
		bookSale.setPriceSold(price);
		bookSales.add(bookSale);
		registerEvent(this);
		registerEvent(new BookSold(this.getId(), this.getPrice()));
	}
	
	public void changeInfo(String name, String description) {
		this.name = name;
		this.description = description;
		lastDateUpdated = OffsetDateTime.now();
		registerEvent(this);
	}
}
