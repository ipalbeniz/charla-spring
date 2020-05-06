package com.demo.exchangeclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ExchangeRateClient {

	private static final String BASE_URL = "https://api.exchangeratesapi.io/latest";

	private final RestTemplate restTemplate;

	public ExchangeRateClient(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public float getExchangeRate(final String fromCurrency, final String toCurrency) {

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(BASE_URL);
		uriBuilder.queryParam("base", fromCurrency);
		uriBuilder.queryParam("symbols", toCurrency);

		CurrencyResponse currencyResponse = restTemplate.getForObject(uriBuilder.build().toUri(), CurrencyResponse.class);

		return currencyResponse.getRates().get(toCurrency);
	}
}
