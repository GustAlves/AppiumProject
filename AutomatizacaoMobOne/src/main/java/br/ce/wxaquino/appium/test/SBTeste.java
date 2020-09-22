package br.ce.wxaquino.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBContasPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBHomePage;
import br.ce.wcaquino.appium.page.seuBarriga.SBLoginPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBMenuPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBMovimentacaoPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBResumoPage;

public class SBTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage menuSB = new SBMenuPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBHomePage home = new SBHomePage();
	private SBResumoPage resumo = new SBResumoPage();

	@Before
	public void setup() {
		menu.acessarSBNativo();
		login.setEmail("teste@poc.com");
		login.setSenha("123");
		login.entrar();
		login.reset();
		esperar(1000);
	}

	@Test
	public void deveInserirContaComSucesso() {
		// entrar em contas
		menuSB.acessarContas();

		// digitar nome conta
		contas.setConta("Conta de Teste");

		// salvar
		contas.salvar();

		// Verificar mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
	}

	@Test
	public void deveExcluirConta() {

		// entrar em contas
		menuSB.acessarContas();

		// clique longo na conta
		contas.selecionarConta("Conta para alterar");

		// ecluir
		contas.excluir();

		// verificar mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta exclu�da com sucesso"));
	}

	@Test
	public void deveValidarInclusaoMov() {
		menuSB.acessarMovimentacoes();

		// validar desc
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Descri��o � um campo obrigat�rio"));

		// validar inte
		mov.setDescricao("Desc");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Interessado � um campo obrigat�rio"));

		// validar valor
		mov.setInteressado("interess");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Valor � um campo obrigat�rio"));

		// validar conta
		mov.setValor("123");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Conta � um campo obrigat�rio"));

		// inserir com sucesso
		mov.setConta("Conta para alterar");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Movimenta��o cadastrada com sucesso"));
	}

	//@Test
	public void deveAtualizarSaldoAoExcluirMovimentacao() {
		// verificar saldo "Conta para saldo" = 534.00
		Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));

		// ir para resumo
		menuSB.acessarResumo();

		// excluir Movimentacao 3
		resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");

		// validar a mensagem "Movimenta��o removida com sucesso"
		Assert.assertTrue(resumo.existeElementoPorTexto("Movimenta��o removida com sucesso!"));

		// voltar home
		menuSB.acessarHome();

		// atualizar saldos
		esperar(2000);
		home.scroll(0.2, 0.9);

		// verificar saldo = -1000.00
		Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
	}
}
