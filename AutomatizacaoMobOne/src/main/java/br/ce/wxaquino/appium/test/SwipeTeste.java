package br.ce.wxaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;

public class SwipeTeste extends BaseTest {

	private MenuPage menu = new MenuPage();

	@Test
	public void deveRealizarSwipe() {
		// Acessar menu
		menu.acessarSwipe();

		// Verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

		// Swipe para direita
		menu.swipeRight();

		// Verificar texto ' e veja se'
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

		// Clicar botão direita
		menu.clicarPorTexto("›");

		// Verificar o texto 'Chegar até o fim!'
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));

		// Swipe esquerda
		menu.swipeLeft();

		// Clicar botão esquerda
		menu.clicarPorTexto("‹");

		// Verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}

}
