package com.demo.service;

import com.demo.exchangeclient.ExchangeRateClient;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

	private final ExchangeRateClient exchangeRateClient;

	public CurrencyExchangeService(final ExchangeRateClient exchangeRateClient) {
		this.exchangeRateClient = exchangeRateClient;
	}

	public float getExchange(final float amount, final String fromCurrency, final String toCurrency) {

		final float exchangeRate = this.exchangeRateClient.getExchangeRate(fromCurrency, toCurrency);

		return amount * exchangeRate;
	}
}
