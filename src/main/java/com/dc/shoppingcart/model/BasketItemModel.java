package com.dc.shoppingcart.model;

import com.dc.shoppingcart.enums.OfferCodeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketItemModel {

	private String name;
	private OfferCodeEnum offer;
	private double unitPrice;
}
