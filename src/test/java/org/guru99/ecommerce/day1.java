//verify_item_sorting

package org.guru99.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class day1 {
    @Test
    public void verify1(){
        System.setProperty("webdriver.chrome.driver", "/Users/mukul/Documents/Testing/Automation/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://live.techpanda.org/index.php/");

        //Verifying title of the page
        String title = driver.getTitle();
        if (title.equals("Home page")) {
            System.out.println(title + " matches!");
        }

        //CLICKING ON MOBILE!

        //Below commented xpath can also be used!
        //driver.findElement(By.xpath("//a[@class = 'level0 'and text() = 'Mobile']")).click();
        driver.findElement(By.linkText("MOBILE")).click();

        //Verifying title of the page
        String title2 = driver.getTitle();
        if (title2.equals("Mobile")) {
            System.out.println(title2 + " matches!");
        }

        //Finding products on the page:
        List<WebElement> productElements = driver.findElements(By.xpath("//h2[@class='product-name']"));

        //1. Creating list to store product names:
        List<String> productNames = new ArrayList<>();

        //1. Extracting product names and adding to list
        for (WebElement productElement : productElements) {
            productNames.add(productElement.getText());
        }


        //Selecting dropdown by name
        WebElement sortby = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
        sortby.click();

        Select dropdown = new Select(sortby);
        dropdown.selectByVisibleText("Name");



        //2. Creating list to store SORTED product names
        List<String> SortedProductNames = new ArrayList<>(productNames);
        Collections.sort(SortedProductNames);

        //Comparing the original and sorted product names
        boolean isSorted = productNames.equals(SortedProductNames);

        if (isSorted){
            System.out.println("Products are sorted as names");
        }
        else {
            System.out.println("Products are not sorted as names");
        }

        driver.quit();




























//        driver.quit();






    }
}
