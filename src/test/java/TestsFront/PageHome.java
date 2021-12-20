package TestsFront;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
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
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void TesteNavegarParaGoogle() {
		driver.get("https://online.sp.senai.br/");
		
		WebElement input = driver.findElement(By.id("Busca1_txtFiltro"));
		
		input.sendKeys("Gestão");
		//input.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("Busca1_btnBusca")).click();
	}
}
	