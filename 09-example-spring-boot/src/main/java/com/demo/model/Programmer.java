package com.demo.model;

import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(value = "programmers")
public class Programmer {

	private String username;
	private String name;
	private int age;
	private List<String> languages;
}
