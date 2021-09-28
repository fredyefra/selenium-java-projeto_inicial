package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.cenarios.ICenariosTest;

public class LoginTest implements ICenariosTest {

	private LoginPageObject loginPagePO;

	/**
	 * antes de CADA execucao
	 */
	@BeforeEach
	@Override
	public void beforeEach() {
		this.loginPagePO = new LoginPageObject();
	}

	/**
	 * FINAL de cada execucao fechar o browser
	 */
	@AfterEach
	@Override
	public void afterEach() {
		loginPagePO.finalizarTeste();
	}

	@Test
	public void deveriaEfetuarLoginDadosValidos() {
		loginPagePO.paginaLogin();
		loginPagePO.preencherUsuarioSenhaLogin("fulano", "pass");
		loginPagePO.submeterFormulario();

		Assert.assertFalse(loginPagePO.isPaginaDeLogin());
		Assert.assertEquals("fulano", loginPagePO.usuarioLogado());
	}

	@Test
	public void naoDeveriaEfetuarLoginDadosInvalidos() {
		loginPagePO.paginaLogin();
		loginPagePO.preencherUsuarioSenhaLogin("qualquecoisa", "123456");
		loginPagePO.submeterFormulario();

		Assert.assertTrue(loginPagePO.isPaginaDeLoginError());
		Assert.assertNull("fulano", loginPagePO.usuarioLogado());
		Assert.assertTrue(loginPagePO.contemTexto("Usuário e senha inválidos."));
	}

	@Test
	public void paginaRestritaNaoLogado() {
		loginPagePO.paginaLeilao();

		Assert.assertTrue(loginPagePO.isPaginaDeLogin());
		Assert.assertFalse(loginPagePO.contemTexto("Dados do Leilão"));

	}
}