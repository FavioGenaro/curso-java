package com.unmsm.software.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoanRegisterForm1Test {
	private WebDriver driver;

	@BeforeAll
	static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setup() {
		driver = new ChromeDriver();
		driver.get("http://127.0.0.1:3000");
		driver.manage().window().maximize();

	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}

	@Test
	void CU01_Test() {
		WebElement bookIdField = driver.findElement(By.id("bookId"));
		bookIdField.clear();
		bookIdField.sendKeys("00000");

		WebElement userIdField = driver.findElement(By.id("userId"));
		userIdField.clear();
		userIdField.sendKeys("100000");

		WebElement planIdField = driver.findElement(By.id("planId"));
		planIdField.clear();
		planIdField.sendKeys("0000");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.clear();
		passwordField.sendKeys("00000");

		WebElement loanTypeDropdown = driver.findElement(By.id("loanType"));
		loanTypeDropdown.click();
		WebElement loanOption = driver.findElement(By.xpath("//option[text()='General']"));
		loanOption.click();

		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

		WebElement successMessage = driver.findElement(By.id("successMessageText"));
		assertTrue(successMessage.isDisplayed(), "La información fue registrada exitosamente");
	}

	@Test
	void CU02_Test() {
		WebElement bookIdField = driver.findElement(By.id("bookId"));
		bookIdField.clear();
		bookIdField.sendKeys("zzzzz");

		WebElement userIdField = driver.findElement(By.id("userId"));
		userIdField.clear();
		userIdField.sendKeys("999999");

		WebElement planIdField = driver.findElement(By.id("planId"));
		planIdField.clear();
		planIdField.sendKeys("9999");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.clear();
		passwordField.sendKeys("zzzzz");

		WebElement loanTypeDropdown = driver.findElement(By.id("loanType"));
		loanTypeDropdown.click();
		WebElement loanOption = driver.findElement(By.xpath("//option[text()='Reserva']"));
		loanOption.click();

		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

		WebElement successMessage = driver.findElement(By.id("successMessageText"));
		assertTrue(successMessage.isDisplayed(), "La información fue registrada exitosamente");
	}

	@Test
	void CU03_Test() {
		WebElement bookIdField = driver.findElement(By.id("bookId"));
		bookIdField.clear();
		bookIdField.sendKeys("aaaa");

		WebElement userIdField = driver.findElement(By.id("userId"));
		userIdField.clear();
		userIdField.sendKeys("100001");

		WebElement planIdField = driver.findElement(By.id("planId"));
		planIdField.clear();
		planIdField.sendKeys("0001");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.clear();
		passwordField.sendKeys("aaaaa");

		WebElement loanTypeDropdown = driver.findElement(By.id("loanType"));
		loanTypeDropdown.click();
		WebElement loanOption = driver.findElement(By.xpath("//option[text()='General']"));
		loanOption.click();

		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

		WebElement successMessage = driver.findElement(By.id("errorText"));
		assertTrue(successMessage.isDisplayed(), "Código de libro erróneo");
	}

	@Test
	void CU04_Test() {
		WebElement bookIdField = driver.findElement(By.id("bookId"));
		bookIdField.clear();
		bookIdField.sendKeys("999999");

		WebElement userIdField = driver.findElement(By.id("userId"));
		userIdField.clear();
		userIdField.sendKeys("999998");

		WebElement planIdField = driver.findElement(By.id("planId"));
		planIdField.clear();
		planIdField.sendKeys("9998");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.clear();
		passwordField.sendKeys("99999");

		WebElement loanTypeDropdown = driver.findElement(By.id("loanType"));
		loanTypeDropdown.click();
		WebElement loanOption = driver.findElement(By.xpath("//option[text()='Reserva']"));
		loanOption.click();

		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

		WebElement errorMessage = driver.findElement(By.id("errorText"));
		assertTrue(errorMessage.isDisplayed(), "Código de libro erróneo");
	}

	@Test
	void CU05_Test() {
		WebElement bookIdField = driver.findElement(By.id("bookId"));
		bookIdField.clear();
		bookIdField.sendKeys("1aaa1");

		WebElement userIdField = driver.findElement(By.id("userId"));
		userIdField.clear();
		userIdField.sendKeys("99999");

		WebElement planIdField = driver.findElement(By.id("planId"));
		planIdField.clear();
		planIdField.sendKeys("0000");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.clear();
		passwordField.sendKeys("2999z");

		WebElement loanTypeDropdown = driver.findElement(By.id("loanType"));
		loanTypeDropdown.click();
		WebElement loanOption = driver.findElement(By.xpath("//option[text()='General']"));
		loanOption.click();

		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

		WebElement errorMessage = driver.findElement(By.id("errorText"));
		assertTrue(errorMessage.isDisplayed(), "Código de usuario erróneo");
	}

	@Test
	void CU06_Test() {
		WebElement bookIdField = driver.findElement(By.id("bookId"));
		bookIdField.sendKeys("a111a");

		WebElement userIdField = driver.findElement(By.id("userId"));
		userIdField.sendKeys("1000000");

		WebElement planIdField = driver.findElement(By.id("planId"));
		planIdField.sendKeys("9999");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("9zzz9");

		WebElement loanTypeDropdown = driver.findElement(By.id("loanType"));
		loanTypeDropdown.click();
		WebElement loanOption = driver.findElement(By.xpath("//option[text()='Reserva']"));
		loanOption.click();

		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

		WebElement errorMessage = driver.findElement(By.id("errorText"));
		assertTrue(errorMessage.isDisplayed(), "Código de usuario erróneo");
	}

	@Test
	void CU07_Test() {
		WebElement bookIdField = driver.findElement(By.id("bookId"));
		bookIdField.sendKeys("d1ad8");

		WebElement userIdField = driver.findElement(By.id("userId"));
		userIdField.sendKeys("555555");

		WebElement planIdField = driver.findElement(By.id("planId"));
		planIdField.sendKeys("000");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("5d7x4");

		WebElement loanTypeDropdown = driver.findElement(By.id("loanType"));
		loanTypeDropdown.click();
		WebElement loanOption = driver.findElement(By.xpath("//option[text()='General']"));
		loanOption.click();

		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

		WebElement errorMessage = driver.findElement(By.id("errorText"));
		assertTrue(errorMessage.isDisplayed(), "Código de plan erróneo");
	}

	@Test
	void CU08_Test() {
		WebElement bookIdField = driver.findElement(By.id("bookId"));
		bookIdField.sendKeys("e55sq");

		WebElement userIdField = driver.findElement(By.id("userId"));
		userIdField.sendKeys("777777");

		WebElement planIdField = driver.findElement(By.id("planId"));
		planIdField.sendKeys("10000");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("00000");

		WebElement loanTypeDropdown = driver.findElement(By.id("loanType"));
		loanTypeDropdown.click();
		WebElement loanOption = driver.findElement(By.xpath("//option[text()='Reserva']"));
		loanOption.click();

		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

		WebElement errorMessage = driver.findElement(By.id("errorText"));
		assertTrue(errorMessage.isDisplayed(), "Código de plan erróneo");
	}

	@Test
	void CU09_Test() {
		WebElement bookIdField = driver.findElement(By.id("bookId"));
		bookIdField.sendKeys("E4e17");

		WebElement userIdField = driver.findElement(By.id("userId"));
		userIdField.sendKeys("222222");

		WebElement planIdField = driver.findElement(By.id("planId"));
		planIdField.sendKeys("1234");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("0000");

		WebElement loanTypeDropdown = driver.findElement(By.id("loanType"));
		loanTypeDropdown.click();
		WebElement loanOption = driver.findElement(By.xpath("//option[text()='General']"));
		loanOption.click();

		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

		WebElement errorMessage = driver.findElement(By.id("errorText"));
		assertTrue(errorMessage.isDisplayed(), "Contraseña errónea");
	}

	@Test
	void CU10_Test() {
		WebElement bookIdField = driver.findElement(By.id("bookId"));
		bookIdField.sendKeys("9sg0F");

		WebElement userIdField = driver.findElement(By.id("userId"));
		userIdField.sendKeys("123456");

		WebElement planIdField = driver.findElement(By.id("planId"));
		planIdField.sendKeys("9876");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("zzzzzz");

		WebElement loanTypeDropdown = driver.findElement(By.id("loanType"));
		loanTypeDropdown.click();
		WebElement loanOption = driver.findElement(By.xpath("//option[text()='Reserva']"));
		loanOption.click();

		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

		WebElement errorMessage = driver.findElement(By.id("errorText"));
		assertTrue(errorMessage.isDisplayed(), "Contraseña errónea");
	}

	@Test
	void CU11_Test() {
		WebElement bookIdField = driver.findElement(By.id("bookId"));
		bookIdField.sendKeys("8fedR");

		WebElement userIdField = driver.findElement(By.id("userId"));
		userIdField.sendKeys("987654");

		WebElement planIdField = driver.findElement(By.id("planId"));
		planIdField.sendKeys("3743");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("4wD6f");

		WebElement loanTypeDropdown = driver.findElement(By.id("loanType"));
		loanTypeDropdown.click();
		WebElement loanOption = driver.findElement(By.xpath("//option[text()='[Seleccionar]']"));
		loanOption.click();

		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

		WebElement errorMessage = driver.findElement(By.id("errorText"));
		assertTrue(errorMessage.isDisplayed(), "Tipo de préstamo erróneo");
	}
}
