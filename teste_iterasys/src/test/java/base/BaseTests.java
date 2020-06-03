package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;

public class BaseTests {
	
	private static WebDriver driver;
	protected HomePage homePage;
	
	@BeforeAll // primeiro metodo a ser executado - configuração do webdriver
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", "/home/vitateje/Desktop/projects/selenium_java/teste_iterasys/drivers/chrome/83/chromedriver");
		driver = new ChromeDriver();
	}
	
	@BeforeEach // carregar antes de cada teste
	public void carregarPaginaInicial() {
		driver.get("https://marcelodebittencourt.com/demoprestashop/");
		homePage = new HomePage(driver);
	}
	
	@AfterAll // apos execução da classe de testes ( para fechar o browser )
	public static void finalizar() {
		driver.quit();
	}

}
