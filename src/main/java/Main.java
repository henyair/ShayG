import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;

        System.out.println("Please enter your username");
        String name = scanner.next();
        System.out.println("please enter your password ");
        String password = scanner.next();

        System.setProperty("webdriver.chrome.driver","c:\\Chromedriver.exe");
        ChromeDriver driver= new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
        driver.manage().window().maximize();
        WebElement PersonalInformation=driver.findElement(By.cssSelector("a[href=\"https://portal.aac.ac.il\"]"));
        PersonalInformation.click();
        WebElement Name= driver.findElement(By.id("Ecom_User_ID"));
        Name.sendKeys(name);
        WebElement MyPassword=driver.findElement(By.id("Ecom_Password"));
        MyPassword.sendKeys(password);
        WebElement GetIn =driver.findElement(By.id("wp-submit"));
        GetIn.click();
        WebElement YourMoodle=driver.findElement(By.cssSelector("a[href=\"https://moodle.aac.ac.il/login/index.php\"]"));
        YourMoodle.click();
        try {
            Thread.sleep(4000);

        }catch (InterruptedException e){

        }
        List<WebElement> coures=driver.findElements(By.cssSelector("a[class=\"aalink coursename\"]"));
        for (WebElement coure : coures) {
            System.out.println(coure.getText());

        }
        System.out.println("peak your course");
        int course= scanner.nextInt();
        coures.get(course).click();
        try {
            Thread.sleep(4000);

        }catch (InterruptedException e){

        }
        WebElement out=driver.findElement(By.id("action-menu-toggle-1"));
        out.click();
        WebElement out1=driver.findElement(By.cssSelector("a[data-title=\"logout,moodle\"]"));
        out1.click();
        WebElement outModdle = driver.findElement(By.cssSelector("a[href=\\\"https://portal.aac.ac.il/AGLogout\\\"]"));
        outModdle.click();
    }
}
