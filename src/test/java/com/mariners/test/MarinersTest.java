package com.mariners.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mariners.page.MarinersPage;

public class MarinersTest {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void urlLoading() {
		driver.get("https://marinersforex.com/Flights-Booking");
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws Exception {
		
		MarinersPage p = new MarinersPage(driver);
		p.botHandling();
		p.leavingArrivingMariners("Kochi", "Bahrain");
		
		p.calenderSelect();
		p.oneWayDatePicking("26", "November", "2024");
		
		p.travellersClassesSelect();
		
		p.adultClickIncrement();
		p.childClickIncrement();
		p.selectBusinessClass();
		Thread.sleep(3000);
		p.done();
		p.searchForFlights();
	}
	
}
