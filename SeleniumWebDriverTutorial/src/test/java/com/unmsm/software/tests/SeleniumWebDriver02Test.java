package com.unmsm.software.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWebDriver02Test {
	private WebDriver driver;
	
	@BeforeAll
	static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setup() {
		driver = new ChromeDriver();
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}

	@Test
	void CheckTitleAfterQueryTest() {
		// Abrimos una página web.
        driver.get("https://www.google.com");
        
        // Maximizamos la ventana.
		driver.manage().window().maximize();
        
        // Buscamos la caja de texto del buscador y simulamos la acción de búsqueda.
        driver.findElement(By.name("q")).sendKeys("UNMSM" + Keys.RETURN);
        
        // Esperamos tres segundos para que se complete la búsqueda.
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(3));
        waiter.until(ExpectedConditions.titleContains("UNMSM"));

        
        // Imprimimos el título de la página.
        String actualTitle = driver.getTitle();
        String expectedTitle = "UNMSM - Buscar con Google";
        
        System.out.println("Título de la página: " + actualTitle);
        
        assertTrue(actualTitle.contains(expectedTitle));
	}
}
