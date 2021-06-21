package com.qa.hobbyproject.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
@Sql(scripts = { "classpath:teamsTest-schema.sql",
		"classpath:teamsTest-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
class FantasyTeamsPageTest {

	private static WebDriver driver;
	private static WebElement targ;
	
	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
	}
	
	@Test
	void testCreateTeam() {
		driver.get("http://localhost:8080/Team.html");
		
		targ = driver.findElement(By.xpath("/html/body/button"));
		targ.click();
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("teamModal")));
		
		targ = driver.findElement(By.id("teamName"));
		targ.click();
		targ.sendKeys("Paris Eternal");
		
		targ = driver.findElement(By.xpath("//*[@id=\"createTeam\"]/button"));
		targ.click();
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[1]/table/tbody/tr[2]")));
		
		assertEquals("2", driver.findElement(By.xpath("/html/body/main/div[1]/table/tbody/tr[2]/td[2]")).getText());
		assertEquals("Paris Eternal", driver.findElement(By.xpath("/html/body/main/div[1]/table/tbody/tr[2]/td[3]")).getText());
		
	}
	
	@Test
	void testRead() {
		driver.get("http://localhost:8080/Team.html");
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[1]/table/tbody/tr[1]")));
		
		assertEquals("1", driver.findElement(By.xpath("/html/body/main/div[1]/table/tbody/tr[1]/td[2]")).getText());
		assertEquals("Surrey Stags", driver.findElement(By.xpath("/html/body/main/div[1]/table/tbody/tr[1]/td[3]")).getText());
		
	}
	
	@Test
	void testUpdateTeam() {
		driver.get("http://localhost:8080/Team.html");
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[1]/table/tbody/tr[1]")));
		
		targ = driver.findElement(By.xpath("/html/body/main/div[1]/table/tbody/tr[1]/td[1]/button"));
		targ.click();
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("uTeamModal")));
		
		targ = driver.findElement(By.id("updateTeamName"));
		targ.click();
		targ.clear();
		targ.sendKeys("Dallas Fuel");
		
		targ = driver.findElement(By.xpath("//*[@id=\"updateTeamButton\"]"));
		targ.click();
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[1]/table/tbody/tr[1]")));
		
		assertEquals("1", driver.findElement(By.xpath("/html/body/main/div[1]/table/tbody/tr[1]/td[2]")).getText());
		assertEquals("Surrey Stags", driver.findElement(By.xpath("/html/body/main/div[1]/table/tbody/tr[1]/td[3]")).getText());
		
	}
	
	@Test 
	void testDeleteTeam() {
		driver.get("http://localhost:8080/Team.html");
		
		targ = driver.findElement(By.xpath("/html/body/main/div[1]/table/tbody/tr[1]/td[4]/button"));
		targ.click();
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/main/div[1]/table/tbody/tr")));
		
		assertTrue(driver.findElements(By.xpath("/html/body/main/div[1]/table/tbody/tr")).size() < 1);
		
	}
	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
}

