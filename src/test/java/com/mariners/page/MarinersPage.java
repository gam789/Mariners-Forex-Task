package com.mariners.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarinersPage {
	
	WebDriver driver;
	//LEAVINGFROM and ARRIVINGTO
	@FindBy (xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/section[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement leavingFromField;
	@FindBy (xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/section[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement arrivingToField;
	
	
	//DATEPICKING
	@FindBy (xpath = "//*[@id=\"root\"]/div/div[2]/section/div[1]/form/div[2]/div[2]/div[2]/div/div/div/button") WebElement calender;
	@FindBy (xpath = "/html/body/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/div") WebElement monthElement;
	@FindBy (xpath = "/html/body/div[2]/div[2]/div/div/div/div[1]/div[1]/div[2]/div") WebElement yearElement;
	@FindBy (xpath =  "//body/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div/div/button") 
	List<WebElement> monthDates;
	@FindBy (xpath = "/html/body/div[2]/div[2]/div/div/div/div[1]/div[2]/button[2]") WebElement nextMonth;
	
	//TRAVELLERS,CLASSES
	@FindBy (xpath = "//*[@id=\"root\"]/div/div[2]/section/div[1]/form/div[2]/div[3]/ul/li/div") WebElement travellersClasses;
	@FindBy (xpath = "//*[@id=\"root\"]/div/div[2]/section/div[1]/form/div[2]/div[3]/ul/li/ul/li[1]/div/div/div[3]/p") WebElement adultClick;
	@FindBy (xpath = "//*[@id=\"root\"]/div/div[2]/section/div[1]/form/div[2]/div[3]/ul/li/ul/li[2]/div/div/div[3]/p") WebElement childclick;
	@FindBy (xpath = "//*[@id=\"root\"]/div/div[2]/section/div[1]/form/div[2]/div[3]/ul/li/ul/li[4]/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")
	WebElement businessClassClick;
	@FindBy (xpath = "//*[@id=\"root\"]/div/div[2]/section/div[1]/form/div[2]/div[3]/ul/li/ul/li[4]/div/div[2]") WebElement doneClick;
	
	@FindBy (xpath = "//*[@id=\"root\"]/div/div[2]/section/div[1]/form/div[2]/div[4]/input") WebElement searchClick;
	
	
	public MarinersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void botHandling() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		
		driver.switchTo().frame("BotPenguin");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[3]/button/span[1]")).click();
		driver.switchTo().defaultContent();
	}
	
	public void leavingArrivingMariners(String leaving, String arriving) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		leavingFromField.click();
		leavingFromField.sendKeys(leaving);
		Thread.sleep(5000);
		leavingFromField.sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		arrivingToField.click();
		arrivingToField.sendKeys(arriving);
		Thread.sleep(5000);
		arrivingToField.sendKeys(Keys.ENTER);
	}
	
	public void calenderSelect() {
		calender.click();
	}
	
	public void oneWayDatePicking(String day, String month, String year) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		while(true) {
			String monthText = monthElement.getText();
			String yearText = yearElement.getText();
			
			if(monthText.equalsIgnoreCase(month) && yearText.equals(year)) {
				break;
			}else {
				nextMonth.click();
			}
			
		}
		
		
		for(WebElement date:monthDates) {
			String dateValue = date.getText();
			if(dateValue.equals(day)) {
				date.click();
			}
		}
		
		
	}
	
	public void travellersClassesSelect() {
		travellersClasses.click();
	}
	
	public void adultClickIncrement() {
		adultClick.click();
	}
	
	public void childClickIncrement() {
		childclick.click();
	}
	
	public void selectBusinessClass() {
		businessClassClick.click();
	}
	
	public void done() {
		doneClick.click();
	}
	
	public void searchForFlights() {
		searchClick.click();
	}
	
	
}
