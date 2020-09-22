package br.ce.wxaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SwipeListPage;

public class SwipeElementTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();

	@Test
	public void deveResolverDesafio() {
		menu.clicarSwipeList();
		page.swipeElementRight("Op��o 1");
		page.clicarBotaoMais();

		Assert.assertTrue(page.existeElementoPorTexto("Op��o 1 (+)"));

		page.swipeElementRight("Op��o 4");
		page.clicarPorTexto("(-)");

		Assert.assertTrue(page.existeElementoPorTexto("Op��o 4 (-)"));

		page.swipeElementLeft("Op��o 5 (-)");

		Assert.assertTrue(page.existeElementoPorTexto("Op��o 5"));
	}

}
