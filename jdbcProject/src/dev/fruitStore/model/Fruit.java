package dev.fruitStore.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Fruit {
	private int id;
	private String name;
	private LocalDate stock;
	private String unit;
	private int price;
	private String origin;
	
	
	
	public Fruit() {
		
	}
	
	public Fruit(int id, String name, LocalDate stock, String unit, int price, String origin) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.unit = unit;
		this.price = price;
		this.origin = origin;
	}
	
}
