package FOPtests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.junit.Test;


public class FOPtests {

	public void test1_three_part_name() {

	WebDriver driver = new FirefoxDriver();
    // Navigate to a web page
    driver.get("http://www.fop.com");
    // Perform actions on HTML elements, entering text and submitting the form
    WebElement customernameElement     = driver.findElement(By.name("customername"));
    WebElement formElement        = driver.findElement(By.id("loginForm"));
    customernameElement.sendKeys("Tim Martin Barksdale");
    
    formElement.submit();        // submit by form element
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement messageElement = wait.until(
       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
    );
    String message                 = messageElement.getText();
    String successMsg             = "Welcome to the fop website. You logged in successfully.";
    Assert.assertEquals (message, successMsg);
    driver.quit();
   }
		    
	@Test
    public void test2_name_w_JR() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("Joe Allen Smith Jr.");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String successMsg             = "Welcome to the fop website. You logged in successfully.";
	    Assert.assertEquals (message, successMsg);
	    driver.quit();
   }
	@Test
    public void test3_name_with_a_third() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("Bill Johnson III");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String successMsg             = "Welcome to the fop website. You logged in successfully.";
	    Assert.assertEquals (message, successMsg);
	    driver.quit();
   }
	
	@Test
    public void test4_name_with_ext_char() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("Zhaozhang Böö");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String successMsg             = "Welcome to the fop website. You logged in successfully.";
	    Assert.assertEquals (message, successMsg);
	    driver.quit();
   }
	@Test
    public void test5_name_with_a_dash() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("Billy-Rae Jackson");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String successMsg             = "Welcome to the fop website. You logged in successfully.";
	    Assert.assertEquals (message, successMsg);
	    driver.quit();
   }
	@Test
    public void test6_name_with_a_single_word() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("Prince");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String successMsg             = "Welcome to the fop website. You logged in successfully.";
	    Assert.assertEquals (message, successMsg);
	    driver.quit();
   }
	
	@Test
    public void test7_name_with_max_stringlength128() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefgh");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String successMsg             = "Welcome to the fop website. You logged in successfully.";
	    Assert.assertEquals (message, successMsg);
	    driver.quit();
   }
	@Test
    public void test8_name_with_max_stringlength128_plus_one() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghi");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String failureMsg             = "Invalid customer name. Please try again.";
	    Assert.assertEquals (message, failureMsg);
	    driver.quit();
   }
	@Test
    public void test9_name_with_blank_username() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String failureMsg             = "Invalid customer name. Please try again.";
	    Assert.assertEquals (message, failureMsg);
	    driver.quit();
   }
	@Test
    public void test10_name_with_alphanumeric() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("Tim2 Bar0ksdal3");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String failureMsg             = "Invalid customer name. Please try again.";
	    Assert.assertEquals (message, failureMsg);
	    driver.quit();
   }
   
}