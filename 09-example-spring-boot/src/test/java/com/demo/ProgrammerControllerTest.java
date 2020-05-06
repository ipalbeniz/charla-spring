package com.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import com.demo.model.Programmer;
import com.demo.repository.ProgrammerRepository;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProgrammerControllerTest {

	@LocalServerPort
	private int port;

	@MockBean
	private ProgrammerRepository programmerRepository;

	@Before
	public void setUp() {
		RestAssured.port = port;
	}

	@Test
	public void it_should_get_an_existing_programmer() {

		mockProgrammerRepositoryBehavior();

		given()

		.when()
			.get("/app/programmers/{username}", "iperez")

		.then()
			.statusCode(HttpStatus.OK.value())
			.body("username", is("iperez"))
			.body("name", is("Íñigo Montoya"))
			.body("age", is(33));
	}

	private void mockProgrammerRepositoryBehavior() {

		Programmer programmer = new Programmer();
		programmer.setUsername("iperez");
		programmer.setName("Íñigo Montoya");
		programmer.setAge(33);

		BDDMockito.given(programmerRepository.findByUsername("iperez"))
			.willReturn(programmer);
	}
}
