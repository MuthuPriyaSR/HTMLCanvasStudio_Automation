package com.at.BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainClass extends BaseClass {
	
	@FindBy (xpath = "//input[@title='Draw a line']")
	WebElement drawALine;
	
	@FindBy (id = "imageTemp")
	WebElement imageTemp;
	
	public MainClass() {
		PageFactory.initElements(driver, this);
	}
	
	public void drawALine() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(drawALine));
		Actions action = new Actions(driver);

		action.moveToElement(drawALine).click().build().perform();
	}
	
	public void drawHorizontalLine() {
		Actions action = new Actions(driver);
		action.dragAndDropBy(imageTemp, -200, 0).click().build().perform();
		action.dragAndDropBy(imageTemp, 200, 0).click().build().perform();
	}
	
	public void drawVerticalLine()  {
		Actions action = new Actions(driver);
		action.dragAndDropBy(imageTemp, 0, -200).click().build().perform();
		action.dragAndDropBy(imageTemp, 0, 200).click().build().perform();
	}

}
