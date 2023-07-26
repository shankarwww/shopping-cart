package com.dc.shoppingcart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriceCalculatorServiceTest {

	PriceCalculatorService calculatorService = new PriceCalculatorService();

	@BeforeEach
	void beforeEach() {
		// put your logic for which needs to be called before each test case
	}

	@Test
	void testPriceOfBasketOfApples() {
		List<String> basketOfpples = Arrays.asList("Apple", "Apple", "Apple", "Apple");

		double totalPrice = this.calculatorService.getTotalPrice(basketOfpples);
		assertEquals(140, totalPrice);
	}

	@Test
	void testPriceOfBasketOfBananas() {
		List<String> basketOfBananas = Arrays.asList("Banana", "Banana", "Banana", "Banana", "Banana");

		double totalPrice = this.calculatorService.getTotalPrice(basketOfBananas);
		assertEquals(100, totalPrice);
	}

	@Test
	void testPriceOfBasketOfMelons() {
		List<String> basketOfMelons = Arrays.asList("Melon", "Melon", "Melon");

		double totalPrice = this.calculatorService.getTotalPrice(basketOfMelons);
		assertEquals(100, totalPrice);
	}

	@Test
	void testPriceOfBasketOfLimes() {
		List<String> basketOfMelons = Arrays.asList("Lime", "Lime", "Lime", "Lime");
		double totalPrice = this.calculatorService.getTotalPrice(basketOfMelons);
		assertEquals(45, totalPrice);
	}

	@Test
	void testPriceOfDifferentBasketOfItems() {
		List<String> basket = Arrays.asList("Banana", "Banana", "Banana",
				"Melon", "Melon", "Melon",
				"Apple", "Apple", "Apple",
				"Lime", "Lime", "Lime", "Lime");

		double totalPrice = this.calculatorService.getTotalPrice(basket);
		assertEquals(310, totalPrice);
	}

	@Test
	void testPriceOfEmptyBasket() {
		List<String> basket = Arrays.asList();

		double totalPrice = this.calculatorService.getTotalPrice(basket);
		assertEquals(0, totalPrice);
	}

}
