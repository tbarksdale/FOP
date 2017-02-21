package FOPtests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.junit.Test;


public class DecisionTable_FOPtests {

	@Test
    public void test1_end_to_end_successful_ent_client() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("Tim Barksdale");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String successMsg             = "Welcome to the fop website. You logged in successfully.";
	    Assert.assertEquals (message, successMsg);
	    
	    //Now assume the webpage starts asking questions to determine if FOP should be granted or not.
	    //we will assume the questions asked will follow the same order as the user story states
	    //First question is if an enterprise client or a platinum personal client
	    
	    WebElement entclientElement     = driver.findElement(By.name("EntClientButton"));
	    entclientElement.click();
	    
	    //Next it asks user if they have a checking account or not
	    WebElement checkingacctyesElement     = driver.findElement(By.name("CheckingYESButton"));
	    checkingacctyesElement.click();
	    
	    //Next question is if the cutomer has $200,000 or more in deposits
	    WebElement depositsElement     = driver.findElement(By.name("DepositsYESButton"));
	    depositsElement.click();
	    
	    //Next question is - does the customer already have overdraft protection?
	    WebElement alreadyfopElement     = driver.findElement(By.name("fopNoButton"));
	    alreadyfopElement.click();
	    
	    //and final question is - does the customer have fewer than five overdrafts 
	    //in the last twelve months?
	    WebElement fewerthanfiveElement     = driver.findElement(By.name("overdraftfewerYESButton"));
	    fewerthanfiveElement.click();
	    
	    //submit all of the answers
	    WebElement submitElement        = driver.findElement(By.id("submitButton"));
	    submitElement.click();
	    
	    //so now since all questions were answered correctly to approve overdraft protection,
	    //verify success message
	    WebDriverWait wait2 = new WebDriverWait(driver, 5);
	    WebElement responseElement = wait2.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("Response"))
	    );
	    String successmessage                 = responseElement.getText();
	    String expectedsuccessMsg             = "You have been approved for Free Overdraft Protection.";
	    Assert.assertEquals (successmessage, expectedsuccessMsg);
	    
	    driver.quit();
   }
	@Test
    public void test2_end_to_end_successful_platinum_client() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("Tim Barksdale");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String successMsg             = "Welcome to the fop website. You logged in successfully.";
	    Assert.assertEquals (message, successMsg);
	    
	    //Now assume the webpage starts asking questions to determine if FOP should be granted or not.
	    //we will assume the questions asked will follow the same order as the user story states
	    //First question is if an enterprise client or a platinum personal client
	    
	    WebElement platclientElement     = driver.findElement(By.name("PlatClientButton"));
	    platclientElement.click();
	    
	    //Next it asks user if they have a checking account or not
	    WebElement checkingacctyesElement     = driver.findElement(By.name("CheckingYESButton"));
	    checkingacctyesElement.click();
	    
	    //Next question is if the cutomer has $200,000 or more in deposits
	    WebElement depositsElement     = driver.findElement(By.name("DepositsYESButton"));
	    depositsElement.click();
	    
	    //Next question is - does the customer already have overdraft protection?
	    WebElement alreadyfopElement     = driver.findElement(By.name("fopNoButton"));
	    alreadyfopElement.click();
	    
	    //and final question is - does the customer have fewer than five overdrafts 
	    //in the last twelve months?
	    WebElement fewerthanfiveElement     = driver.findElement(By.name("overdraftfewerYESButton"));
	    fewerthanfiveElement.click();
	    
	    //submit all of the answers
	    WebElement submitElement        = driver.findElement(By.id("submitButton"));
	    submitElement.click();
	    
	    //so now since all questions were answered correctly to approve overdraft protection,
	    //verify success message
	    WebDriverWait wait2 = new WebDriverWait(driver, 5);
	    WebElement responseElement = wait2.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("Response"))
	    );
	    String successmessage                 = responseElement.getText();
	    String expectedsuccessMsg             = "You have been approved for Free Overdraft Protection.";
	    Assert.assertEquals (successmessage, expectedsuccessMsg);
	    
	    driver.quit();
   }
	@Test
    public void test3_already_have_fop() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("Tim Barksdale");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String successMsg             = "Welcome to the fop website. You logged in successfully.";
	    Assert.assertEquals (message, successMsg);
	    
	    //Now assume the webpage starts asking questions to determine if FOP should be granted or not.
	    //we will assume the questions asked will follow the same order as the user story states
	    //First question is if an enterprise client or a platinum personal client
	    
	    WebElement platclientElement     = driver.findElement(By.name("PlatClientButton"));
	    platclientElement.click();
	    
	    //Next it asks user if they have a checking account or not
	    WebElement checkingacctyesElement     = driver.findElement(By.name("CheckingYESButton"));
	    checkingacctyesElement.click();
	    
	    //Next question is if the customer has $200,000 or more in deposits
	    WebElement depositsElement     = driver.findElement(By.name("DepositsYESButton"));
	    depositsElement.click();
	    
	    //Next question is - does the customer already have overdraft protection? we answer yes for this test.
	    WebElement alreadyfopElement     = driver.findElement(By.name("fopYesButton"));
	    alreadyfopElement.click();
	    
	    //verify failure message
	    WebDriverWait wait2 = new WebDriverWait(driver, 5);
	    WebElement responseElement = wait2.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("Response"))
	    );
	    String failuremessage                 = responseElement.getText();
	    String expectedfailureMsg             = "You have been denied for Free Overdraft Protection.";
	    Assert.assertEquals (failuremessage, expectedfailureMsg);
	    
	    driver.quit();
   }
	@Test
    public void test4_no_checking() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("Tim Barksdale");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String successMsg             = "Welcome to the fop website. You logged in successfully.";
	    Assert.assertEquals (message, successMsg);
	    
	    //Now assume the webpage starts asking questions to determine if FOP should be granted or not.
	    //we will assume the questions asked will follow the same order as the user story states
	    //First question is if an enterprise client or a platinum personal client
	    
	    WebElement platclientElement     = driver.findElement(By.name("PlatClientButton"));
	    platclientElement.click();
	    
	    //Next it asks user if they have a checking account or not. we enter a no for this test.
	    WebElement checkingacctnoElement     = driver.findElement(By.name("CheckingNOButton"));
	    checkingacctnoElement.click();
	    
	  //verify failure message
	    WebDriverWait wait2 = new WebDriverWait(driver, 5);
	    WebElement responseElement = wait2.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("Response"))
	    );
	    String failuremessage                 = responseElement.getText();
	    String expectedfailureMsg             = "You have been denied for Free Overdraft Protection.";
	    Assert.assertEquals (failuremessage, expectedfailureMsg);
	    
	    driver.quit();
   }
	@Test
    public void test5_not_enough_deposits() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("Tim Barksdale");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String successMsg             = "Welcome to the fop website. You logged in successfully.";
	    Assert.assertEquals (message, successMsg);
	    
	    //Now assume the webpage starts asking questions to determine if FOP should be granted or not.
	    //we will assume the questions asked will follow the same order as the user story states
	    //First question is if an enterprise client or a platinum personal client
	    
	    WebElement platclientElement     = driver.findElement(By.name("PlatClientButton"));
	    platclientElement.click();
	    
	    //Next it asks user if they have a checking account or not
	    WebElement checkingacctyesElement     = driver.findElement(By.name("CheckingYESButton"));
	    checkingacctyesElement.click();
	    
	    //Next question is if the customer has $200,000 or more in deposits
	    WebElement depositsnoElement     = driver.findElement(By.name("DepositsNoButton"));
	    depositsnoElement.click();
	    
	  //verify failure message
	    WebDriverWait wait2 = new WebDriverWait(driver, 5);
	    WebElement responseElement = wait2.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("Response"))
	    );
	    String failuremessage                 = responseElement.getText();
	    String expectedfailureMsg             = "You have been denied for Free Overdraft Protection.";
	    Assert.assertEquals (failuremessage, expectedfailureMsg);
	    
	    driver.quit();
   }
	@Test
    public void test6_more_than_five_overdrafts() throws Exception {
		WebDriver driver = new FirefoxDriver();
	    // Navigate to a web page
	    driver.get("http://www.fop.com");
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement customernameElement     = driver.findElement(By.name("customername"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	    customernameElement.sendKeys("Tim Barksdale");
	    
	    formElement.submit();        // submit by form element
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	    );
	    String message                 = messageElement.getText();
	    String successMsg             = "Welcome to the fop website. You logged in successfully.";
	    Assert.assertEquals (message, successMsg);
	    
	    //Now assume the webpage starts asking questions to determine if FOP should be granted or not.
	    //we will assume the questions asked will follow the same order as the user story states
	    //First question is if an enterprise client or a platinum personal client
	    
	    WebElement platclientElement     = driver.findElement(By.name("PlatClientButton"));
	    platclientElement.click();
	    
	    //Next it asks user if they have a checking account or not
	    WebElement checkingacctyesElement     = driver.findElement(By.name("CheckingYESButton"));
	    checkingacctyesElement.click();
	    
	    //Next question is if the customer has $200,000 or more in deposits
	    WebElement depositsElement     = driver.findElement(By.name("DepositsYESButton"));
	    depositsElement.click();
	    
	    //Next question is - does the customer already have overdraft protection?
	    WebElement alreadyfopElement     = driver.findElement(By.name("fopNoButton"));
	    alreadyfopElement.click();
	    
	    //and final question is - does the customer have fewer than five overdrafts. for this test we say no
	    //in the last twelve months?
	    WebElement fewerthanfiveNoElement     = driver.findElement(By.name("overdraftfewerNOButton"));
	    fewerthanfiveNoElement.click();
	    
	  //verify failure message
	    WebDriverWait wait2 = new WebDriverWait(driver, 5);
	    WebElement responseElement = wait2.until(
	       ExpectedConditions.presenceOfElementLocated(By.id("Response"))
	    );
	    String failuremessage                 = responseElement.getText();
	    String expectedfailureMsg             = "You have been denied for Free Overdraft Protection.";
	    Assert.assertEquals (failuremessage, expectedfailureMsg);
	    
	    driver.quit();
	    
   }
	   
}