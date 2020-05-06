package com.demo.exchangeclient;

import java.time.LocalDate;
import java.util.Map;
import lombok.Data;

@Data
public class CurrencyResponse {

	private Map<String, Float> rates;
	private String base;
	private LocalDate date;
}
