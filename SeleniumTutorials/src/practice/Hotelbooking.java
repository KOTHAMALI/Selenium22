package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hotelbooking extends Web{
	
	@Test
	
	public void Verifyheader() throws InterruptedException{
		
		getDriver().manage().window().maximize();

		
		
		webDriverFluentWait(By.id("hdr-deals")).click();
		webDriverFluentWait(By.id("qf-1q-destination")).sendKeys("London");
		
		Thread.sleep(1000);
		List<WebElement> list = getDriver().findElements(By.id("citysqm-asi0-s0"));
		for (WebElement element : list) {
			if (element.getText().contains("London, United Kingdom")) {
				element.click();
				break;
			}
		}
		webDriverFluentWait(By.id("qf-1q-localised-check-in")).sendKeys(tomarrowDate());
		
		webDriverFluentWait(By.id("qf-1q-localised-check-out")).clear();
		
		webDriverFluentWait(By.id("qf-1q-localised-check-out")).sendKeys(afterSevendayDate());
		
		Select dropdown = new Select(webDriverFluentWait(By.id("qf-1q-rooms")));
		dropdown.selectByVisibleText("2");
		
		Select dropdownAdults = new Select(webDriverFluentWait(By.id("qf-1q-room-0-adults")));
		dropdownAdults.selectByVisibleText("2");
		
		Select dropdownChildren = new Select(webDriverFluentWait(By.id("qf-1q-room-0-children")));
		dropdownChildren.selectByVisibleText("1");
		
		Select dropdownChildage = new Select(webDriverFluentWait(By.id("qf-1q-room-0-child-0-age")));
		dropdownChildage.selectByVisibleText("2");
		
		Select dropdownRoomadults = new Select(webDriverFluentWait(By.id("qf-1q-room-1-adults")));
		dropdownRoomadults.selectByVisibleText("4");
		
		Select dropdownRoomchild = new Select(webDriverFluentWait(By.id("qf-1q-room-1-children")));
		dropdownRoomchild.selectByVisibleText("0");
		
		webDriverFluentWait(By.xpath(".//*[@id='main-content']/main/div/div/div[1]/div/div[1]/div[2]/div/div/form/fieldset[4]/button")).click();
		String actual = webDriverFluentWait(By.xpath(".//*[@id='search']/div/div/h1")).getText();
		String expected = "London, England, United Kingdom";
		Assert.assertEquals(actual, expected);	
			
		
	}

	}
