package br.ce.wxaquino.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AlertaPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AlertTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();

	@Before
	public void setup() {
		menu.acessarAlertas();
	}

	@Test
	public void deveConfirmarAlerta() {

		// Clicar em alerta confirm
		page.clicarAlertaConfirm();

		// Verificar os textos
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());

		// Confirmar alerta
		page.confirmar();

		// Verificar nova mensagem
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());

		// Sair
		page.sair();
	}

	@Test
	public void deveClicarForaAlerta() {
		// Clicar alerta simples
		page.clicarAlertaSimples();

		// Clicar fora da caixa
		esperar(1000);
		page.clicarForaCaixa();

		// verificar que a mensagem não está mais presente
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));

	}

}
