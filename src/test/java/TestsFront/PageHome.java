package TestsFront;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageHome {
	
	private WebDriver driver;
	
	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", System.getenv("Driver"));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://online.sp.senai.br/");
	}
	
	@Test
	public void Teste() {
		
		//Foram criadas duas variáveis como um workaround, porque estava ocorrendo um bug que impedia o uso de uma variável mais de 2 vezes.
		
		WebElement busca01;
		WebElement busca02;
		
			try {
				
				
				//Primeira pesquisa
				busca01 = driver.findElement(By.name("ctl00$Busca1$txtFiltro"));
				busca01.sendKeys("Gestão");
				busca01.sendKeys(Keys.ENTER);
				
				//Tempo para apurar resultados.				
				Thread.sleep(10000);
				
				//Segunda pesquisa
				busca02 = driver.findElement(By.name("ctl00$Busca1$txtFiltro"));
				busca02.clear();
				busca02.sendKeys("Tecnologia");
				driver.findElement(By.id("Busca1_btnBusca")).click();
				Thread.sleep(10000);
					} catch (InterruptedException exception) {
						exception.printStackTrace();
					}
	}
	
	@After
	public void EncerrarTeste() {
		driver.close();
	}
}