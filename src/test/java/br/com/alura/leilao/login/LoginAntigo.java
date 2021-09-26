package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAntigo {

	/*
	 * @Test public void deveriaEfetuarLoginDadosValidos() {
	 * System.setProperty("webdriver.gecko.driver",
	 * "../2019-selenium-java-projeto_inicial/drivers-selenium/geckodriver");
	 * WebDriver browser = new FirefoxDriver();
	 * browser.navigate().to("http://localhost:8080/login");
	 * browser.findElement(By.id("username")).sendKeys("fulano");
	 * browser.findElement(By.id("password")).sendKeys("pass");
	 * browser.findElement(By.id("login-form")).submit();
	 * 
	 * Assert.assertFalse(browser.getCurrentUrl().equals(
	 * "http://localhost:8080/leiloes")); //Assert.assertEquals("fulano",
	 * browser.findElement(By.id("logado")).getText()); // ERROR
	 * 
	 * browser.quit();
	 * 
	 * }
	 */

	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;

	/**
	 * antes de TODAS execucoes abrir o browser pagina de Login
	 */
	private void beforeAll() {
        
	}

	/**
	 * antes de CADA execucao
	 */
	@BeforeEach
	private void beforeEach() {
		System.setProperty("webdriver.chrome.driver",
				"../2019-selenium-java-projeto_inicial/drivers-selenium/chromedriver");
		this.browser = new ChromeDriver();
	}

	/**
	 * FINAL de cada execucao fechar o browser
	 */
	@AfterEach
	private void afterEach() {
		browser.quit();
	}

	// @Test
	public void deveriaEfetuarLoginDadosValidos() {
		browser.navigate().to(URL_LOGIN);
		browser.findElement(By.id("username")).sendKeys("fulano");
		browser.findElement(By.id("password")).sendKeys("pass");
		browser.findElement(By.id("login-form")).submit();

		Assert.assertFalse(browser.getCurrentUrl().equals(URL_LOGIN));
		Assert.assertEquals("fulano", browser.findElement(By.id("logado")).getText()); // ERROR

	}

	@Test
	public void naoDeveriaEfetuarLoginDadosInvalidos() {
		System.setProperty("webdriver.chrome.driver",
				"../2019-selenium-java-projeto_inicial/drivers-selenium/chromedriver");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to(URL_LOGIN);
		browser.findElement(By.id("username")).sendKeys("qualquercoisa");
		browser.findElement(By.id("password")).sendKeys("123456");
		browser.findElement(By.id("login-form")).submit();

		Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
		Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
		Assert.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("logado")));

		browser.quit();

	}

	/*
	 * @Test public void naoDeveriaEfetuarLoginDadosInvalidos() {
	 * System.setProperty("webdriver.chrome.driver",
	 * "../2019-selenium-java-projeto_inicial/drivers-selenium/chromedriver");
	 * WebDriver browser = new ChromeDriver();
	 * browser.navigate().to("http://127.0.0.1:8080/login");
	 * browser.findElement(By.id("username")).sendKeys("qualquercoisa");
	 * browser.findElement(By.id("password")).sendKeys("123456");
	 * browser.findElement(By.id("login-form")).submit();
	 * 
	 * Assert.assertTrue(browser.getCurrentUrl().contains(
	 * "http://127.0.0.1:8080/login?error"));
	 * Assert.assertTrue(browser.getPageSource().
	 * contains("Usuário e senha inválidos."));
	 * //Assert.assertNotSame("fulano",browser.findElement(By.id("username")).
	 * getText());
	 * 
	 * 
	 * //browser.quit();
	 * 
	 * }
	 */

}
