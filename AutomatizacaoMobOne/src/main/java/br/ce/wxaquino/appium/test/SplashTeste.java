package br.ce.wxaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SplashPage;

public class SplashTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();

	@Test
	public void deveAguardarSplahSumir() {
		// Acessar menu Splash
		menu.acessarSplash();

		// Verificar que o splah esta sendo exibido
		page.isTelaSplashVisivel();

		// Aguardar saida do splah
		page.aguardarSplashSumir();

		// Verificar que o formulário esta aparecendo
		Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
	}

}
