//Verify that cost of product on list page and details page are equal

package org.guru99.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day2 {

    @Test
    public void verify2() {

        System.setProperty("webdriver.chrome.driver", "/Users/mukul/Documents/Testing/Automation/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://live.techpanda.org/index.php");

        //Clicking on Mobile tab
        driver.findElement(By.xpath("//a[contains(@href, 'http://live.techpanda.org/index.php/mobile.html')]")).click();

        //Reading the price of Sony Xperia
        WebElement PriceTag1 = driver.findElement(By.xpath("//span[@id = 'product-price-1']//span"));
        String Xperia_Price1 = PriceTag1.getText();
        System.out.println("The price on Mobile list page is: " + Xperia_Price1);

        //Clicking on Sony Xperia
        driver.findElement(By.xpath("//a[@title = 'Sony Xperia']")).click();

        //Reading the price of Sony Xperia on detailed page
        WebElement PriceTag2 = driver.findElement(By.xpath("//span[@class = 'price']"));
        String Xperia_Price2 = PriceTag2.getText();
        System.out.println("The price on Mobile Detailed Page is: " + Xperia_Price2);

        //Comparing both the prices
        Assert.assertEquals(Xperia_Price2, Xperia_Price1);
        driver.quit();





    }
}
