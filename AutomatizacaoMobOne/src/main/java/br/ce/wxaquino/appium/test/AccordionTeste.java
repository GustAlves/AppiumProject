package br.ce.wxaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AccordionPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AccordionTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();

	@Test
	public void deveInteragirComAccordion() {
		// Acessar menu
		menu.acessarAccordion();

		// Clicar opção 1
		page.selecionarOp1();

		// Verificar texto opção 1
		esperar(1000);
		Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOp1());
	}

}
