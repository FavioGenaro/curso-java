package com.unmsm.software.app;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWebDriver02 {

	public static void main(String[] args) {
		System.out.println("Ejecutando SeleniumWebDriver02");
		
		WebDriverManager.chromedriver().setup();

		// Creamos la instancia del Chrome Driver.
		WebDriver driver = new ChromeDriver();

		// Abrimos una página web.
		driver.get("https://www.google.com");

		// Buscamos la caja de texto del buscador y simulamos la acción de búsqueda.
		driver.findElement(By.name("q")).sendKeys("UNMSM" + Keys.RETURN);

		// Esperamos tres segundos para que se complete la búsqueda.
		// Nota: En la práctica real, es mejor usar las esperas de Selenium.
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Imprimimos el título de la página.
		System.out.println("Título de la página: " + driver.getTitle());

		// Cerramos el navegador.
		driver.quit();
	}

}
