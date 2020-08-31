package base;

import java.util.concurrent.TimeUnit;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
	private static WebDriver driver;
	
	
	
	
	
	@Before
	
	public void inicializar () {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\84\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://marcelodebittencourt.com/demoprestashop/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@After
	
	public void finalizar () {
	driver.quit();
		
	}
	
	@Test
	
	public void consultarProduto() {
		//Consultar um produto específico
		WebElement buscar = driver.findElement(By.cssSelector("input[class='ui-autocomplete-input']"));
		buscar.sendKeys("HUMMINGBIRD CUSHION");
		
		
		WebElement botaobuscar = driver.findElement(By.cssSelector("i[class='material-icons search']"));
		botaobuscar.click();
		WebElement resultadoproduto = driver.findElement(By.cssSelector("a[class='thumbnail product-thumbnail']"));
		resultadoproduto.click();
		
		



		
	}
	

	
	@Test
	public void adicionarCarrinho () {
		consultarProduto();
		//Selecionar a cor preta
		driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[1]/div/ul/li[2]/label/input\r\n"))
		.click();
		//Selecionar a quantidade
		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys("1");
		driver.findElement(By.cssSelector("button[class='btn btn-primary add-to-cart']")).click();
		driver.findElement(By.cssSelector("a.btn-primary")).click();

		
	}
	
	@Test
	
	public void validarProduto() {
		adicionarCarrinho();
		String corProduto ;
		String nomeProduto ;
		String valorProduto;
		//String quantidadeProduto ;
		String valorTotalProduto;
		
		
		
		nomeProduto = driver.findElement(By.cssSelector("div[class='product-line-info']")).getText();
		corProduto = driver.findElement(By.cssSelector("span[class='value']")).getText();
		valorProduto = driver.findElement(By.cssSelector("span[class='price']")).getText();
		//quantidadeProduto = driver.findElement(By.cssSelector("div[class='js-cart-line-product-quantity form-control']")).getText();
		//valorTotalProduto = driver.findElement(By.cssSelector("span[class='value']")).getText();
		valorTotalProduto = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]")).getText();
		System.out.println(nomeProduto);
		System.out.println(corProduto);
		System.out.println(valorProduto);
		System.out.println(valorTotalProduto);
		//System.out.println(quantidadeProduto);
		//Assert.assertEquals(corProduto, "Black");
	}
	
	
	
}



