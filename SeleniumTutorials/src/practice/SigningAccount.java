package practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SigningAccount extends Web {
	
	@Test
	
	public void signin(){
	
	webDriverFluentWait(By.id("hdr-account")).click();
	webDriverFluentWait(By.id("hdr-signin")).click();
	webDriverFluentWait(By.id("sign-in-email")).sendKeys("kprkmr");
	webDriverFluentWait(By.id("sign-in-password")).sendKeys("alphagamma");
	webDriverFluentWait(By.xpath("html/body/div[7]/div/div[1]/div/div/form/div[2]/button")).click();
	String actual=webDriverFluentWait(By.xpath("html/body/div[7]/div/div[1]/div/div/p")).getText();
	String expected="We don’t recognize the email and password combination you’ve entered. Please try again, or if you’ve forgotten your password we’ll help reset it";
	Assert.assertEquals(actual,expected);
	
	
	
}

}
