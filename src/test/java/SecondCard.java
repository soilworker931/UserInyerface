import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class SecondCard {
    WebDriver driver;

    SecondCard(WebDriver driver) {
        this.driver = driver;
    }

    boolean atPage() {
        if (driver.getTitle().equals("User Inyerface - A worst-practice UI experiment")) {
            return true;
        } else return false;
    }

    void chooseDifferentHobbies() {
        driver.findElement(By.xpath("(//span[@class=\"checkbox__box\"])[21]")).click();
        ArrayList<Integer> hobbiesList = new ArrayList<Integer>();
        for (int i = 1; i < 20; i++) {
            hobbiesList.add(i);
        }
        hobbiesList.removeIf(i -> (i == 18));
        for (int i = 0; i < 3; i++) {
            int generatedHobby = hobbiesList.get((int) (Math.random() * hobbiesList.size()));
            String xPathForHobbies = "(//span[@class=\"checkbox__box\"])[" + generatedHobby +  "]";
            driver.findElement(By.xpath(xPathForHobbies)).click();
            hobbiesList.removeIf(j -> (j == generatedHobby));
        }
    }

    public static void uploadFile(String fileLocation) throws AWTException, InterruptedException {
        StringSelection stringSelection = new StringSelection(fileLocation);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
        Thread.sleep(2000);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    void fileUpload() throws InterruptedException, AWTException {
        driver.findElement(By.xpath("//a[@class=\"avatar-and-interests__upload-button\"]")).click();
        uploadFile("https://www.questionpro.com/blog/wp-content/uploads/2015/03/primary-test-it.png");
    }

}
