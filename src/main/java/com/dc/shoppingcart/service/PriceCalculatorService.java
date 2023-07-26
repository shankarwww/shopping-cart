package com.dc.shoppingcart.service;

import static com.dc.shoppingcart.enums.OfferCodeEnum.BUY_1_GET_1_FREE;
import static com.dc.shoppingcart.enums.OfferCodeEnum.BUY_3_FOR_THE_PRICE_OF_2;
import static com.dc.shoppingcart.enums.OfferCodeEnum.NONE;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.dc.shoppingcart.model.BasketItemModel;

public class PriceCalculatorService {

	private static final BasketItemModel APPLE = new BasketItemModel("Apple", NONE, 35);
	private static final BasketItemModel BANANA = new BasketItemModel("Banana", NONE, 20);
	private static final BasketItemModel MELON = new BasketItemModel("Melon", BUY_1_GET_1_FREE, 50);
	private static final BasketItemModel LIME = new BasketItemModel("Lime", BUY_3_FOR_THE_PRICE_OF_2, 15);

	private static final List<BasketItemModel> ITEM_LIST = Arrays.asList(APPLE, BANANA, MELON, LIME);

	public double getTotalPrice(List<String> itemName) {
		Map<String, Long> grouped = itemName
				.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		double totalPrice = grouped.entrySet()
				.stream()
				.mapToDouble(this::getPrice)
				.sum();

		return totalPrice;

	}

	private double getPrice(Entry<String, Long> entry) {
		double price = 0;

		String itemName = entry.getKey();
		long count = entry.getValue();

		BasketItemModel itemDetail = getItemDetail(itemName);

		if (BUY_1_GET_1_FREE.equals(itemDetail.getOffer())) {
			long quotient = count / 2;
			long remainder = count % 2;
			price = (quotient + remainder) * itemDetail.getUnitPrice();

		} else if (BUY_3_FOR_THE_PRICE_OF_2.equals(itemDetail.getOffer())) {
			long quotient = count / 3;
			long remainder = count % 3;

			price = (quotient * 2 + remainder) * itemDetail.getUnitPrice();

		} else if (NONE.equals(itemDetail.getOffer())) {
			price = count * itemDetail.getUnitPrice();
		}

		return price;
	}

	private BasketItemModel getItemDetail(String itemName) {
		return ITEM_LIST
				.stream()
				.filter(item -> item.getName().equals(itemName))
				.findFirst()
				.get();
	}

}
