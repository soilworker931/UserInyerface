import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstPage {

    WebDriver driver;

    FirstPage(WebDriver driver) {
        this.driver = driver;
    }

    void open() {
        driver.get("https://userinyerface.com/game.html%20target=");
    }

    boolean atPage() {
        if (driver.getTitle().equals("User Inyerface - A worst-practice UI experiment")) {
            return true;
        } else return false;
    }

    void pushHEREbutton() {
        driver.findElement(By.className("start__link")).click();
    }
}
