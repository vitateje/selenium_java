// 1 - Pacote

package siteIterasys;

//2 - Bibliotecas

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// 3 - Classe

public class Cursos {
	// 3.1 Atributos / Caracteristicas
	String url;  // endereço do site alvo
	WebDriver driver; // objeto do Selenium WebDriver

	
	
	// 3.2 Métodos ou Funções
	@Before
	public void iniciar() {
		url = "https://www.iterasys.com.br";

		System.setProperty("webdriver.chrome.driver",
				"/home/vitateje/iterasys-workspace/siteIterasys/drivers/chrome/83/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		
		}
	
	@After
	public void finalizar() {
		driver.quit();
				
	}
	
	@Test
	public void consultarCurso() {
		// Home - Pagina Inicial
		driver.get(url); // Abrir o navegador na pagina indicada na url
		driver.findElement(By.id("searchtext")).clear();
		driver.findElement(By.id("searchtext")).sendKeys(Keys.chord("Mantis"));
		
		// Tirar o screenshot
		driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);		
		
		// Pagina que lista os cursos
		driver.findElement(By.cssSelector("span.comprar")).click();
		
		// Pagina do Carrinho de Compra
		// Resultados Esperados
		String titulo = "Mantis";
		String preco = "R$ 49,99";
		
		//assertEquals(resultadoEsperado, resultadoAtual);
		assertEquals(titulo, driver.findElement(By.cssSelector("span.item-title")).getText());
		assertEquals(preco, driver.findElement(By.cssSelector("span.new-price")).getText());
		
		
		}
	
} 	   




