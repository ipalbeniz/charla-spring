package com.demo.controller;

import com.demo.service.CurrencyExchangeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/exchange")
@RestController
public class CurrencyExchangeController {

	private CurrencyExchangeService currencyExchangeService;

	public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
		this.currencyExchangeService = currencyExchangeService;
	}

	@GetMapping
	public float getExchange(
		@RequestParam("amount") float amount,
		@RequestParam("fromCurrency") String fromCurrency,
		@RequestParam("toCurrency") String toCurrency
	) {

		return currencyExchangeService.getExchange(
			amount,
			fromCurrency,
			toCurrency
		);
	}
}
