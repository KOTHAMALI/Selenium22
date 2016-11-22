package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hotelprice extends Hotelbooking{
	
	@Test
	
	public void Pricechecking() throws InterruptedException{
		
		//getDriver().findElement(By.xpath(".//*[@id='filter-price']/div[2]/div/div[2]/div[3]")).click();
		
        WebElement source = webDriverFluentWait(By.xpath(".//*[@id='filter-price']/div[2]/div/div[2]/div[3]"));
        WebElement target = webDriverFluentWait(By.xpath(".//*[@id='filter-price']/div[2]/div/div[2]/div[2]"));
        Actions action = new Actions(getDriver());
        action.dragAndDropBy(source,-92,0).release().build().perform();
        String actual = webDriverFluentWait(By.xpath(".//*[@id='listings']/ol/li[1]/article/div/div[3]/div[1]/a/span/ins")).getText();
        int result = Integer.parseInt(actual);
        int expected = 200;
        
        if(result>expected){
        	Assert.fail("price morethan 200");
        }
        else{
        	System.out.println("price less than 200");
        }
      
        Thread.sleep(10000);
	}

}
