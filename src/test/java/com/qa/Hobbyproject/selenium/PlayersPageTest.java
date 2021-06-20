package com.qa.Hobbyproject.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT) 
@Sql(scripts = { "classpath:fantasyTeams-schema.sql",
		"classpath:fantasyTeams-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class PlayersPageTest {

	private static WebDriver driver;
	private static WebElement targ;
	
	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
	}
	
	@Test
	public void testCreatePlayer() {
		driver.get("http://localhost:8080/Player.html");
		
		targ = driver.findElement(By.xpath("/html/body/button"));
		targ.click();
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("playerModal")));
		
		targ = driver.findElement(By.id("playerIGN"));
		targ.click();
		targ.sendKeys("Haksal");
		
		targ = driver.findElement(By.id("role"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"role\"]/option[4]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"createPlayer\"]/button"));
		targ.click();
		
		targ = driver.findElement(By.xpath("//*[@id=\"playerModal\"]/div/div/div[1]/button"));
		targ.click();
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[1]/table/tbody/tr[1]")));
		
		assertEquals("2", driver.findElement(By.xpath("/html/body/main/div[1]/table/tbody/tr[2]/td[2]")).getText());
		assertEquals("Haksal", driver.findElement(By.xpath("/html/body/main/div[1]/table/tbody/tr[2]/td[3]")).getText());
		assertEquals("Flex DPS", driver.findElement(By.xpath("/html/body/main/div[1]/table/tbody/tr[2]/td[4]")).getText());
	}
	
	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
}
