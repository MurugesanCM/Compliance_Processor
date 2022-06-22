package compliance_client_compliance_processor;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Resources.BaseClass;
@Test
public class getFilteredDataCount extends BaseClass {

	public WebDriver driver;

	@Test
	public void createEmployee() throws IOException, InterruptedException {
		// Start Chromedriver
		driver = initializeDriver();
		// Enter URL
		login.URL("UAT");
		// Type User name,Password and click on login
        login.login();
		// Switch to Processor Role
		wait.until(ExpectedConditions.visibilityOf(neosuite.OpenComplianceApplication()));
		login.switchRole("Compliance Client", "Compliance Processor");
		wait.until(ExpectedConditions.stalenessOf(neosuite.OpenComplianceApplication()));
		neosuite.OpenComplianceApplication().click();
		wait.until(ExpectedConditions.visibilityOf(activityHome.activityView()));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='Total Penalties Paid']")));
		activityHome.activityView().click();
		activityHome.clickOnApplyFilter().click();
		generalFunction.scrollIntoView(activityHome.clickOnSelectStatusInApplyFilter());
		activityHome.clickOnSelectStatusInApplyFilter().click();
		activityHome.selectDrpdwnValue("Open").click();
		activityHome.clickOnApplyButton().click();
		wait.until(ExpectedConditions.visibilityOfAllElements(activityHome.getElementsWithStatus("Open")));
		String[] Values = activityHome.getListViewCount();
		int initialCount = Integer.valueOf(Values[1]);
		int totalCount=Integer.valueOf(Values[3]);
		int noOfPages = totalCount/initialCount;
		int statusCount=0;
		for(int i = 0;i<noOfPages;i++)
		{
			driver.findElement(By.xpath("//text()[.=' > ']//parent::a")).click();
			List<WebElement> status = activityHome.getElementsWithStatus("Open");
			statusCount = status.size();
			initialCount = statusCount + initialCount;
		}
		// Verify whether the functionality is working.
		Assert.assertEquals(totalCount, initialCount);
		driver.close();
	}
}
