package br.ce.wxaquino.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.CliquesPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class CliqueTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();

	@Before
	public void setup() {
		menu.acessarCliques();
	}

	@Test
	public void deveRealizarCliqueLongo() {

		// Clique longo
		page.cliqueLongo();

		// Verificar texto
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}

	@Test
	public void deveRealizarCliqueDuplo() {
		
		// Clique duplo
		page.clicarPorTexto("Clique duplo");
		page.clicarPorTexto("Clique duplo");
		
		// Verificar texto
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
	}

}
