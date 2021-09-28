package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Page Object é um padrão que funciona como interface de acesso a elementos da
 * camada de visão – para aplicações web ele representa uma página HTML. Ele é
 * aplicado para abstrair as páginas de uma aplicação com o objetivo de reduzir
 * o acoplamento entre os casos de teste e a aplicação a ser testada.
 */
public class LoginPageObject {

	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;

	public LoginPageObject() {
		System.setProperty("webdriver.chrome.driver",
				"../2019-selenium-java-projeto_inicial/drivers-selenium/chromedriver");
		this.browser = new ChromeDriver();
		// this.browser.navigate().to(URL_LOGIN);
	}

	public LoginPageObject(WebDriver browser) {
		super();
		this.browser = browser;
	}

	public void paginaLogin() {
		this.browser.navigate().to(URL_LOGIN);
	}

	public void paginaLeilao() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");
	}

	public void preencherUsuarioSenhaLogin(String usuario, String senha) {
		browser.findElement(By.id("username")).sendKeys(usuario);
		browser.findElement(By.id("password")).sendKeys(senha);
	}

	public void submeterFormulario() {
		browser.findElement(By.id("login-form")).submit();
	}

	public boolean isPaginaDeLogin() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public boolean isPaginaDeLoginError() {
		return browser.getCurrentUrl().equals("http://localhost:8080/login?error");
	}

	public boolean contemTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}

	public boolean isPaginaLeilao() {
		return browser.getCurrentUrl().equals("http://localhost:8080/leiloes/2");
		// return browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public String usuarioLogado() {
		try {

			return browser.findElement(By.id("logado")).getText();

		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public void finalizarTeste() {
		browser.quit();
	}
}