package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FeedbackHotels extends Web{

	@Test
	public void fillDetails() throws InterruptedException{
		
		webDriverFluentWait(By.id("hdr-feedback")).click();
		switchToWindow(1);
		Thread.sleep(5000);
		webDriverFluentWait(By.id("comment-textarea")).sendKeys("This website time complxity is too bad");
		webDriverFluentWait(By.id("overall-1")).click();
		webDriverFluentWait(By.id("content-2")).click();
		webDriverFluentWait(By.id("design-3")).click();
		webDriverFluentWait(By.id("usability-4")).click();
		Select dropdown = new Select(webDriverFluentWait(By.id("4293415")));
		List<WebElement> option =  dropdown.getOptions();
		for(WebElement dropdownList:option){
			if(dropdownList.getText().equals("Somewhat Likely")){
				dropdownList.click();
			}
		}
		webDriverFluentWait(By.id("answer_4293414-2")).click();
		webDriverFluentWait(By.id("answer_4293413-1")).click();
		webDriverFluentWait(By.id("email_address")).sendKeys("kpr@gmail.com");
		webDriverFluentWait(By.xpath("html/body/form/footer/div/div/div[1]/input")).click();
		switchToRootCloseCurrent();
			
		
		
	}
}