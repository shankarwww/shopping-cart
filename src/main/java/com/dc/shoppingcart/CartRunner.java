package com.dc.shoppingcart;

import java.util.Arrays;
import java.util.List;

import com.dc.shoppingcart.service.PriceCalculatorService;

public class CartRunner {

	public static void main(String[] args) {

		List<String> basket = Arrays.asList(
				"Melon", "Melon", "Melon",
				"Apple", "Apple", "Apple",
				"Banana", "Banana", "Banana",
				"Lime", "Lime", "Lime", "Lime", "Lime", "Lime", "Lime");

		double basketPrice = new PriceCalculatorService().getTotalPrice(basket);
	}
}
