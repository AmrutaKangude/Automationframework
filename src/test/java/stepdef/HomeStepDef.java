package stepdef;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import generic.SeleniumBase;
import pageobjects.HomePage;

public class HomeStepDef {
	HomePage hp=new HomePage();
	@Given("^launch \"([^\"]*)\" browser with url as \"([^\"]*)\"$")
	public void launch_browser_with_url_as(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    hp.launchApplication(arg1, arg2);
	}

	@Given("^verify home page by \"([^\"]*)\" as \"([^\"]*)\"$")
	public void verify_home_page_by_as(String type, String expectedValue) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   String actualTitle= hp.getPageDetail(type);
	   // hp.compareValues(actualTitle, expectedValue);
	}

	@Given("^verify link count as (\\d+)$")
	public void verify_link_count_as(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^close browser$")
	public void close_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    hp.closeApplication(true);
	}


	@Given("^click on \"([^\"]*)\" link on home page$")
	public void click_on_link_on_home_page(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
