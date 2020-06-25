package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.LoginPage;
import pages.ProdutoPage;

public class HomePageTests extends BaseTests { 
	
	@Test
	public void testContarProdutos_oitoProdutosDiferentes() {
		carregarPaginaInicial();
		assertThat(homePage.contarProdutos(), is(8));
	}
	
	@Test
	public void testValidarCarrinhoZerado_ZeroItensNoCarrinho() {
		int produtosNoCarrinho = homePage.obterQuantidadeProdutosNoCarrinho();
		System.out.println(produtosNoCarrinho);
		assertThat(produtosNoCarrinho, is (0));		
	}
	
	// aula - testar o fluxo padrão - p1
	@Test
	public void testValidarDetalhesDoProduto_DescricaoEValorIguais() {
		int indice = 0;
		String nomeProduto_HomePage = homePage.obterNomeProduto(indice);
		String precoProduto_HomePage = homePage.obterPrecoProduto(indice);
		
		System.out.println(nomeProduto_HomePage);
		System.out.println(precoProduto_HomePage);
		
		ProdutoPage produtoPage = homePage.clicarProduto(indice);
		
		String nomeProduto_ProdutoPage = produtoPage.obterNomeProduto();
		String precoProduto_ProdutoPage = produtoPage.obterPrecoProduto();
		
		System.out.println(nomeProduto_ProdutoPage);
		System.out.println(precoProduto_ProdutoPage);
		
		assertThat(nomeProduto_HomePage.toUpperCase(), is (nomeProduto_ProdutoPage.toUpperCase()));
		assertThat(precoProduto_HomePage, is(precoProduto_ProdutoPage));
	}
	
	@Test
	public void testLoginComSucesso_UsuarioLogado() {
		// Clicar no botao Sign in na home page
		
		LoginPage loginPage = homePage.clicarBotaoSignIn();
		
		// Preencher usuario e senha
		
		loginPage.preencherEmail("marcelo@teste.com");
		loginPage.preencherPassword("marcelo");
		
		// Clicar no Botao Sign In para logar
		
		loginPage.clicarBotaoSignIn();
		
		// Validar se o usuario está logado de fato
		
		assertThat(homePage.estaLogado("Marcelo Bittencourt"), is(true));
		
		// retornar apgina inicial
		
		carregarPaginaInicial();
		
	}
	
	@Test
	public void incluirProdutoNoCarrinho_ProdutoIncluidoComSucesso() {
		
		// Pre Condicao
		//Usuario Logado
		if(!homePage.estaLogado("Marcelo Bittencourt")) {
			testLoginComSucesso_UsuarioLogado();
		}
		
		// Teste
		// Selecionando produto
		testValidarDetalhesDoProduto_DescricaoEValorIguais();
		
		// Selecionar tamanho
		
		
		// Selecionar cor
		
		
		// Selecionar quantidade
		
		// Adiconar no carrinho
	}
	
}
