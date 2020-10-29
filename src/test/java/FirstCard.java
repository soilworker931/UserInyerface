import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FirstCard {
    WebDriver driver;

    FirstCard(WebDriver driver) {
        this.driver = driver;
    }

    public String nicknameGeneration() {
        String smallChars = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder generatedSmallchars = new StringBuilder(10);
        for (int i = 0; i < 10; i++)
            generatedSmallchars.append(smallChars.charAt(rnd.nextInt(smallChars.length())));
        String generatedNickName = "A" + generatedSmallchars.toString();
        return generatedNickName;
    }

    public String passwordGeneration() {
        String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChars = "abcdefghijklmnopqrstuvwxyz";
        String cyrillicChars = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        String numbers = "0123456789";
        String specialSymb = "!@#$%^&*()";
        Random rnd = new Random();
        int randomCapitalChars = (int) (Math.random() * capitalChars.length());
        int randomnumber = (int) (Math.random() * numbers.length());
        int randomCyrillicChar = (int) (Math.random() * cyrillicChars.length());
        int randomSpecialSymb = (int) (Math.random() * specialSymb.length());
        String generatedCapitalChar = capitalChars.substring(randomCapitalChars, randomCapitalChars + 1);
        String generatedCyrillicChar = cyrillicChars.substring(randomCyrillicChar, randomCyrillicChar + 1);
        String generatedSpecialSymb = specialSymb.substring(randomSpecialSymb, randomSpecialSymb + 1);
        StringBuilder generatedSmallchars = new StringBuilder(10);
        for (int i = 0; i < 10; i++)
            generatedSmallchars.append(smallChars.charAt(rnd.nextInt(smallChars.length())));

        String generatedPassword = "A" + generatedCapitalChar + generatedCyrillicChar + generatedSpecialSymb + generatedSmallchars + randomnumber;
        return generatedPassword;
    }

    boolean atPage() {
        if (driver.getTitle().equals("User Inyerface - A worst-practice UI experiment")) {
            return true;
        } else return false;
    }

    void insertPassword() {
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Choose Password']"));
        passwordField.clear();
        String generatedPassword = passwordGeneration();
        passwordField.sendKeys(generatedPassword);
    }

    void insertEmail() {
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Your email']"));
        email.clear();
        email.sendKeys(nicknameGeneration());
    }

    void insertDomain() {
        WebElement domain = driver.findElement(By.xpath("//input[@placeholder='Domain']"));
        domain.clear();
        domain.sendKeys("mail");
    }

    void insertOrgCode() {
        driver.findElement(By.className("dropdown__field")).click();
        driver.findElement(By.xpath("//*[contains(text(), '.org')]")).click();
    }

    void termsAccept() {
        driver.findElement(By.className("checkbox__box")).click();
    }

    void moveToTheSecondCard() {
        driver.findElement(By.className("button--secondary")).click();
    }

    void hideHelp() {
        driver.findElement(By.className("discrete")).click();
    }

    boolean checkHelpIsHidden() {
        if (driver.getPageSource().contains("help-form is-hidden")) {
            return true;
        } else return false;
    }

    void closeCookies() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@class=\"button button--solid button--transparent\"]")).click();
    }

    void checkCookiesClosed() {
        Assert.assertFalse(driver.getPageSource().contains("cookies"));
    }

    void timerCheck() {
        Assert.assertEquals("00:00:00",driver.findElement(By.xpath("//div[@class = \"timer timer--white timer--center\"]")).getText());
    }
}
