import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class UserInyerface {
    private FirstPage firstPage;
    private FirstCard firstCard;
    private SecondCard secondCard;
    private ChromeDriver driver;

    @BeforeMethod
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        firstPage = new FirstPage(driver);
        firstCard = new FirstCard(driver);
        secondCard = new SecondCard(driver);

    }

    @Test
    public void testCase1() throws InterruptedException, AWTException {
        firstPage.open();
        firstPage.atPage();
        firstPage.pushHEREbutton();

        firstCard.atPage();
        firstCard.insertPassword();
        firstCard.insertEmail();
        firstCard.insertDomain();
        firstCard.insertOrgCode();
        firstCard.termsAccept();
        firstCard.moveToTheSecondCard();

        secondCard.atPage();
        secondCard.chooseDifferentHobbies();
        secondCard.fileUpload();
    }

    @Test
    public void testCase2() {
        firstPage.open();
        firstPage.atPage();
        firstPage.pushHEREbutton();

        firstCard.hideHelp();
        firstCard.checkHelpIsHidden();
    }

    @Test
    public void testCase3() {
        firstPage.open();
        firstPage.atPage();
        firstPage.pushHEREbutton();

        firstCard.closeCookies();
        firstCard.checkCookiesClosed();
    }

    @Test
    public void testCase4() {
        firstPage.open();
        firstPage.atPage();
        firstPage.pushHEREbutton();

        firstCard.timerCheck();
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}