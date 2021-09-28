package br.com.alura.leilao.lance;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.cenarios.ICenariosTest;

public class NovoLeilaoTest implements ICenariosTest {

	private NovoLeilaoPageObject novoLeilaPagePO;

	/**
	 * antes de CADA execucao
	 */
	@BeforeEach
	@Override
	public void beforeEach() {
		this.novoLeilaPagePO = new NovoLeilaoPageObject();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * FINAL de cada execucao fechar o browser
	 */
	@AfterEach
	@Override
	public void afterEach() {
		novoLeilaPagePO.finalizarTeste();
	}

	@Test
	public void deveriaDarLanceDadosValidos() {
		novoLeilaPagePO.paginaLogin();
		novoLeilaPagePO.preencherUsuarioSenhaLogin("fulano", "pass");
		novoLeilaPagePO.submeterFormulario();

		novoLeilaPagePO.clicarNovoLeila();
		novoLeilaPagePO.preencherFormularioNovoLeilao("Siclano");

		// Assert.assertFalse(novoLeilaPagePO.isPaginaDeLogin());
		// Assert.assertEquals("fulano", novoLeilaPagePO.usuarioLogado());

	}

}