package generic;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumBase extends Base
{
	
	WebDriver driver;
	enum locators{id,name,className,tagName,linkText,partialLinkText,css,xpath}
	
	public String getPageDetail(String type) {
		String result=null;
		if(type.equalsIgnoreCase("title")) {
			result=driver.getTitle();
		}
		else if(type.equalsIgnoreCase("url")){
			result=driver.getCurrentUrl();
		}
		else if(type.equalsIgnoreCase("source")) {
			result=driver.getPageSource();
		}
		else if(type.equalsIgnoreCase("windowhandle")) {
			result=driver.getWindowHandle();
		}
		
		return result;
	}
	public void launchApplication(String browserName,String url)

	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\java\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".\\src\\test\\java\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", ".\\src\\test\\java\\drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("Browser name is incorrect");
		}
		driver.get(url);
		Options op=	driver.manage();
		op.window().maximize();
		
	}
	
	public WebElement identifyElement(locators type,String value) {
		By by = null;
		switch(type) {
		case id:by=By.id(value);
				break;
		case name:by=By.name(value);
		case className:by=By.className(value);
		case tagName:by=By.tagName(value);
		case linkText:by=By.linkText(value);
		case partialLinkText:by=By.partialLinkText(value);
		case css:by=By.cssSelector(value);
		case xpath:by=By.xpath(value);
		}
		return driver.findElement(by);
	}
	
	public List<WebElement> identifyElements(locators type,String value) {
		By by = null;
		switch(type) {
		case id:by=By.id(value);
				break;
		case name:by=By.name(value);
		case className:by=By.className(value);
		case tagName:by=By.tagName(value);
		case linkText:by=By.linkText(value);
		case partialLinkText:by=By.partialLinkText(value);
		case css:by=By.cssSelector(value);
		case xpath:by=By.xpath(value);
		}
		return driver.findElements(by);
	}
	
	
	public void closeApplication(boolean flag)
	{
		if(flag==true)
		{
			driver.quit();  //closes all windows
		}
		else
		{
			driver.close();  //closes only original or one window
		
		}
	}
	
	public void switchToAnotherWindow()
	{
		String parentHandle=driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		
		Iterator<String> itr=handles.iterator();
		while(itr.hasNext()) 
		{
			if(parentHandle.equalsIgnoreCase(itr.next())) 
			{
				continue;
			}
			else {
				driver.switchTo().window(itr.next());
				//System.out.println("hellloo");
				break;
			}
			//System.out.println("Handle is"+itr.next());
		}	
	}
	public void findLinks() {
	List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int i=1;i<links.size();i=i+1) {
			System.out.println(links.get(i).getText());
		}
	}
}


