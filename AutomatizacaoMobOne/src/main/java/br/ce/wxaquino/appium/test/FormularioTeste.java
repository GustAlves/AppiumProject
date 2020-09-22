package br.ce.wxaquino.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.FormularioPage;
import br.ce.wcaquino.appium.page.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		page.escreverNome("Gustavo");

		assertEquals("Gustavo", page.obterNome());
	}

	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
		page.selecionarCombo("Nintendo Switch");

		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}

	@Test
	public void deveInteragirComSwitchECheckBox() throws MalformedURLException {
		Assert.assertFalse(page.isCheckMarcado());
		Assert.assertTrue(page.isSwitchMarcado());

		page.clicarCheck();
		page.clicarSwitch();

		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.isSwitchMarcado());
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		page.escreverNome("Gustavo");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");

		page.salvar();

		Assert.assertEquals("Nome: Gustavo", page.obterNomeCadastrado());
		Assert.assertEquals("Console: switch", page.obterConsoleCadastrado());
		Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Off"));
		Assert.assertTrue(page.obterCheckCadastrado().endsWith("Marcado"));
	}

	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {
		page.escreverNome("Gustavo");
		page.salvarDemorado();

		Assert.assertEquals("Nome: Gustavo", page.obterNomeCadastrado());
	}
	
	@Test
	public void deveAlterarData() {
		page.clicarPorTexto("01/01/2000");
		page.clicarPorTexto("20");
		page.clicarPorTexto("OK");
		
		Assert.assertTrue(page.existeElementoPorTexto("20/2/2000"));
	}
	
	@Test
	public void deveAlterarHora() {
		page.clicarPorTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("10"));
		page.clicar(MobileBy.AccessibilityId("40"));
		page.clicarPorTexto("OK");
		
		Assert.assertTrue(page.existeElementoPorTexto("10:40"));
	}
	
	@Test
	public void deveInteragirComSeekbar() {
		// Clicar no seekbar
		page.clicarSeekBar(0.25);
		
		// Salvar
		page.salvar();
		
		// Obter o valor
	}
}