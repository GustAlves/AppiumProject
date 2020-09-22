package br.ce.wxaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AbaPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AbasTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AbaPage page = new AbaPage();

	@Test
	public void deveInteragirComAbas() {
		// Acessar menu abas
		menu.acessarAbas();

		// Verificar que esta na aba 1
		Assert.assertTrue(page.isAba1());

		// Acessar aba 2
		page.selecionarAba2();

		// Verificar que esta na aba 2
		Assert.assertTrue(page.isAba2());
	}

}
