package br.ce.wxaquino.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.WebViewPage;

public class WebViewTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();

	@Test
	public void deveFazerLogin() {
		// Acessar o menu
		menu.acessarSBHibrido();
		esperar(3000);
		page.entrarContextoWeb();

		// Preencher email
		page.setEmail("gustavoalves@parceirosbrk.com.br");

		// Preencher senha
		page.setSenha(("pa33Lx$k"));

		// Clicar em entrar
		page.entrar();

		// Verificar sucesso
		Assert.assertEquals("Bem vindo, Gustavo!", page.getMensagem());
	}

	@After
	public void tearDown() {
		page.sairContextoWeb();
	}
}
