package PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActivityView {
	public WebDriver driver;
	public Properties prop;
public ActivityView(WebDriver driver,Properties prop2) throws IOException
{
	this.driver=driver;
	this.prop=prop2;
}
public WebElement activityView()
{
	return driver.findElement(By.xpath("//*[@class=\"compliance_dashboard_li\"][2]"));
	
}
public List<WebElement> getElementsWithStatus(String status)
{
	List<WebElement> elements = driver.findElements(By.xpath("//table//td[6]//span//span//span[contains(text(),' " +status+ " ')]"));
	return elements;
}
public WebElement clickOnApplyFilter() {
	// TODO Auto-generated method stub
	return driver.findElement(By.xpath("//img[@title='Apply Filters']"));
}
public WebElement selectDrpdwnValue(String drpdwnvalue) {
	// TODO Auto-generated method stub
		return 	driver.findElement(By.xpath("//div[@role='option']//span[.='"+ drpdwnvalue +"']"));	
}
public WebElement clickOnSelectStatusInApplyFilter()
{
	return driver.findElement(By.xpath("//*[@id=\"statusId\"]/ng-select/div/div/div[2]/input"));
}
public WebElement clickOnApplyButton() {
	// TODO Auto-generated method stub
	return driver.findElement(By.xpath("//span[.='Apply']"));
}
public String[] getListViewCount() {
	// TODO Auto-generated method stub
	String Text = driver.findElement(By.xpath("//*[@id=\"collapsibleHeaderId\"]/div[4]/div[1]/div/span")).getText();
	String[] strSplit=Text.split(" ");
	System.out.println(Text);
	/*
	for(int i=0;i<Text.length();i++)
	{
		System.out.println(strSplit[i]);
		String a = "";
		int currentIndex=i;
		while((int)strSplit[currentIndex]>=48&&(int)(strSplit[currentIndex])<=57)
		{
		a.concat(Character.toString(strSplit[currentIndex]));
		currentIndex++;
		}
		System.out.println(a);
		values.add(a);
	}*/
	return strSplit;
}
}
