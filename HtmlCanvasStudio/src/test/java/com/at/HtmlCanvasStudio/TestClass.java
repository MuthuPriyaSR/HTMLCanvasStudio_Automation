package com.at.HtmlCanvasStudio;

import java.io.IOException;

import javax.management.DescriptorKey;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.at.BaseClass.BaseClass;
import com.at.BaseClass.MainClass;


public class TestClass extends BaseClass {
	
	MainClass mainClass;
	
	@BeforeTest
	public void setUp() throws IOException, InterruptedException {
		setBrowser();
		launchUrl();
	}
	
	@DescriptorKey("Drawing a horizontal and vertical line which intercepts in html canvas studio")
	@Test
	public void drawLines() throws InterruptedException {
		mainClass = new MainClass();
		mainClass.drawALine();
		mainClass.drawHorizontalLine();
		mainClass.drawVerticalLine();
	}
	
	@AfterTest
	public void quit() {
		driver.close();
	}

}
