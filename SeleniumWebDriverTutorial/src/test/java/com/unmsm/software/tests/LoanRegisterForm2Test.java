package com.unmsm.software.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.unmsm.software.tests.pages.LibraryPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoanRegisterForm2Test {
	private WebDriver driver;
	private LibraryPage libraryPage;

	@BeforeAll
	static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setup() {
		driver = new ChromeDriver();
		driver.get("http://127.0.0.1:3000");
		driver.manage().window().maximize();
		libraryPage = new LibraryPage(driver);
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}

	@Test
	void CU01_Test() {
		libraryPage.setBookId("00000");
		libraryPage.setUserId("100000");
		libraryPage.setPlanId("0000");
		libraryPage.setPassword("00000");
		libraryPage.selectLoanType("General");
		libraryPage.submit();

		assertTrue(libraryPage.isSuccessMessageDisplayed(), "La información fue registrada exitosamente");
	}

	@Test
	void CU02_Test() {
		libraryPage.setBookId("zzzzz");
		libraryPage.setUserId("999999");
		libraryPage.setPlanId("9999");
		libraryPage.setPassword("zzzzz");
		libraryPage.selectLoanType("Reserva");
		libraryPage.submit();

		assertTrue(libraryPage.isSuccessMessageDisplayed(), "La información fue registrada exitosamente");
	}

	@Test
	void CU03_Test() {
		libraryPage.setBookId("aaaa");
		libraryPage.setUserId("100001");
		libraryPage.setPlanId("0001");
		libraryPage.setPassword("aaaaa");
		libraryPage.selectLoanType("General");
		libraryPage.submit();

		assertTrue(libraryPage.isErrorMessageDisplayed(), "Código de libro erróneo");
	}

	@Test
	void CU04_Test() {
		libraryPage.setBookId("999999");
		libraryPage.setUserId("999998");
		libraryPage.setPlanId("9998");
		libraryPage.setPassword("99999");
		libraryPage.selectLoanType("Reserva");
		libraryPage.submit();

		assertTrue(libraryPage.isErrorMessageDisplayed(), "Código de libro erróneo");
	}

	@Test
	void CU05_Test() {
		libraryPage.setBookId("1aaa1");
		libraryPage.setUserId("99999");
		libraryPage.setPlanId("0000");
		libraryPage.setPassword("2999z");
		libraryPage.selectLoanType("General");
		libraryPage.submit();

		assertTrue(libraryPage.isErrorMessageDisplayed(), "Código de usuario erróneo");
	}

	@Test
	void CU06_Test() {
		libraryPage.setBookId("a111a");
		libraryPage.setUserId("1000000");
		libraryPage.setPlanId("9999");
		libraryPage.setPassword("9zzz9");
		libraryPage.selectLoanType("Reserva");
		libraryPage.submit();

		assertTrue(libraryPage.isErrorMessageDisplayed(), "Código de usuario erróneo");
	}

	@Test
	void CU07_Test() {
		libraryPage.setBookId("d1ad8");
		libraryPage.setUserId("555555");
		libraryPage.setPlanId("000");
		libraryPage.setPassword("5d7x4");
		libraryPage.selectLoanType("General");
		libraryPage.submit();

		assertTrue(libraryPage.isErrorMessageDisplayed(), "Código de plan erróneo");
	}

	@Test
	void CU08_Test() {
		libraryPage.setBookId("e55sq");
		libraryPage.setUserId("777777");
		libraryPage.setPlanId("10000");
		libraryPage.setPassword("00000");
		libraryPage.selectLoanType("Reserva");
		libraryPage.submit();

		assertTrue(libraryPage.isErrorMessageDisplayed(), "Código de plan erróneo");
	}

	@Test
	void CU09_Test() {
		libraryPage.setBookId("E4e17");
		libraryPage.setUserId("222222");
		libraryPage.setPlanId("1234");
		libraryPage.setPassword("0000");
		libraryPage.selectLoanType("General");
		libraryPage.submit();

		assertTrue(libraryPage.isErrorMessageDisplayed(), "Contraseña errónea");
	}

	@Test
	void CU10_Test() {
		libraryPage.setBookId("9sg0F");
		libraryPage.setUserId("123456");
		libraryPage.setPlanId("9876");
		libraryPage.setPassword("zzzzzz");
		libraryPage.selectLoanType("Reserva");
		libraryPage.submit();

		assertTrue(libraryPage.isErrorMessageDisplayed(), "Contraseña errónea");
	}

	@Test
	void CU11_Test() {
		libraryPage.setBookId("8fedR");
		libraryPage.setUserId("987654");
		libraryPage.setPlanId("3743");
		libraryPage.setPassword("4wD6f");
		libraryPage.selectLoanType("[Seleccionar]");
		libraryPage.submit();

		assertTrue(libraryPage.isErrorMessageDisplayed(), "Tipo de préstamo erróneo");
	}
}
