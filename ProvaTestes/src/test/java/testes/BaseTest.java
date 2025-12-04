package testes;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	protected static WebDriver driver;
	
//	private static final String URL_BASE = "https://duckduckgo.com/";
	private static final String URL_BASE = "file:///C:/Users/36129382024.1n/Downloads/sistema%20(1)/sistema/produtos.html";
    private static final String PATH_DRIVER = "src/test/resources/chromedriver14207444.exe";
    
    @BeforeClass
    public static void iniciar() {
        System.setProperty("webdriver.chrome.driver", PATH_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get(URL_BASE);
    }
    
    @AfterClass
    public static void finalizar() {
    	driver.quit();
    }

}
