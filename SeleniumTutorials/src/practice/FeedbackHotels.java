package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FeedbackHotels extends Web{

	@Test
	public void fillDetails() throws InterruptedException{
		
		getDriver().findElement(By.id("hdr-feedback")).click();
		switchToWindow(1);
		Thread.sleep(5000);
		getDriver().findElement(By.id("comment-textarea")).sendKeys("This website time complxity is too bad");
		getDriver().findElement(By.id("overall-1")).click();
		getDriver().findElement(By.id("content-2")).click();
		getDriver().findElement(By.id("design-3")).click();
		getDriver().findElement(By.id("usability-4")).click();
		Select dropdown = new Select(getDriver().findElement(By.id("4293415")));
		List<WebElement> option =  dropdown.getOptions();
		for(WebElement dropdownList:option){
			if(dropdownList.getText().equals("Somewhat Likely")){
				dropdownList.click();
			}
		}
		getDriver().findElement(By.id("answer_4293414-2")).click();
		getDriver().findElement(By.id("answer_4293413-1")).click();
		getDriver().findElement(By.id("email_address")).sendKeys("kpr@gmail.com");
		getDriver().findElement(By.xpath("html/body/form/footer/div/div/div[1]/input")).click();
		switchToRootCloseCurrent();
			
		
		
	}
}