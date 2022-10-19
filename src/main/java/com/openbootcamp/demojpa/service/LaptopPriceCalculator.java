package com.openbootcamp.demojpa.service;

import com.openbootcamp.demojpa.models.Laptop;


public class LaptopPriceCalculator {

	public double calculatePrice(Laptop laptop) {
		double price= laptop.getPrice();
		if(laptop.getPrice()>400){
			price+=5;
		}
		price +=2.99;
		return price;
	}
}
