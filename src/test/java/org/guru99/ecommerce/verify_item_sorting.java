package org.guru99.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class verify_item_sorting {
    public static void main(String[] args) {
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

        //Selecting dropdown by name
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
        dropdown.click();

        Select selectop = new Select(dropdown);
        selectop.selectByVisibleText("Name");


        //Verifying all products are sorted by name
        List<WebElement> select = driver.findElements(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));

        for(WebElement options: select)
        {
            String option = options.getText();

            if (option.equals("Name"))
        }











//        driver.quit();






    }
}
