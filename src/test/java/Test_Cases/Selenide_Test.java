package Test_Cases;
import static com.codeborne.selenide.Selenide.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.JavaScript;

import static com.codeborne.selenide.Condition.*;

public class Selenide_Test {

	
	@Test
	public void GoogleSearchTest() throws InterruptedException {
		
		//System.setProperty("selenide.browser", "firefox");
		//Configuration.browser="firefox";
		open("https://www.google.com/");
		WebElement search=$(By.name("q"));
		search.sendKeys("Air canada");
		search.sendKeys(Keys.ENTER);
		$(By.xpath("//h3[text()='Air Canada - Official website']")).click();
		$(By.xpath("(//div[@class='abc-ripple-wrapper'])[11]")).should(Condition.appear);
		Selenide.executeJavaScript("window.scrollBy(0,250)");
		//$(By.xpath("//h3[text()=' Access a flight booking ']")).should(Condition.visible);
		
		$(By.xpath("//input[@id='bkmgFlights_origin_trip_1']")).sendKeys("yy");
		Thread.sleep(2000);
	    List<SelenideElement> list=$$(By.xpath("//ul[@id='bkmgFlights_origin_trip_1OptionsPanel']/li/span"));
		
	    for(SelenideElement l:list) {
	    	
	    	System.out.println(l.getText());
	    	//System.out.println("The main");
	    }
	    
	    Thread.sleep(4000);
		
		
		//$(By.xpath("(//abc-ripple[@class='ng-star-inserted'])[14]/div")).click();
		$(By.xpath("(//abc-ripple[@class='ng-star-inserted'])[11]/div")).click();
		Thread.sleep(4000);
		$(By.xpath("(//div[@class='abc-form-element-main-container']/input)[2]")).sendKeys("2K9X7K");
		$(By.xpath("(//div[@class='abc-form-element-main-container']/input)[3]")).sendKeys("Patel");
		$(By.xpath("(//abc-ripple[@class='ng-star-inserted'])[14]/div")).click();
		Thread.sleep(3000);
		//Selenide.executeJavaScript("window.scrollBy(0,6000)");
		
	
		
		
	}
	
	
	
	
	
	
	
	
	
}
