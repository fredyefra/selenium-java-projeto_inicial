package br.com.alura.leilao.lance;

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
public class NovoLeilaoPageObject {

	private static final String LEILAO_LOGIN = "http://localhost:8080/leiloes";
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;

	public NovoLeilaoPageObject() {
		System.setProperty("webdriver.chrome.driver",
				"../2019-selenium-java-projeto_inicial/drivers-selenium/chromedriver");
		this.browser = new ChromeDriver();
		this.browser.manage().window().maximize();
		// this.browser.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);

	}

	public NovoLeilaoPageObject(WebDriver browser) {
		super();
		this.browser = browser;
	}

	public void paginaLogin() {
		this.browser.navigate().to(URL_LOGIN);
	}

	public void preencherUsuarioSenhaLogin(String usuario, String senha) {
		browser.findElement(By.id("username")).sendKeys(usuario);
		browser.findElement(By.id("password")).sendKeys(senha);
	}

	public void finalizarTeste() {
		browser.quit();
	}

	public void submeterFormulario() {
		browser.findElement(By.id("login-form")).submit();
    }

	public boolean isPaginaDeLogin() {
		// return browser.getPageSource().equals(URL_LOGIN);
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public String usuarioLogado() {
		try {

			return browser.findElement(By.id("logado")).getText();

		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public void clicarNovoLeila() {
		browser.findElement(By.id("novo_leilao_link")).click();

	}

	public void preencherFormularioNovoLeilao(String nome) {
		browser.findElement(By.id("nome")).sendKeys(nome);

	}
}
