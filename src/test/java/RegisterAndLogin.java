import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class RegisterAndLogin
{
    public static WebDriver driver;
    String registerPageExpectedTitle = "nopCommerce demo store. Register";
    String registerPageActualTitle;

    String expectedRegisterSuccessMsg="Your registration completed";

    String actualRegisterSuccessMsg;

    @BeforeAll
    public static void setUp()
    {
       driver = new ChromeDriver();
       driver.navigate().to("https://demo.nopcommerce.com/");
       driver.manage().window().maximize();

    }


    @Test

    public void register()
    {
       driver.findElement(By.linkText("Register")).click();
       registerPageActualTitle = driver.getTitle();
       Assertions.assertEquals(registerPageExpectedTitle,registerPageActualTitle);
       driver.findElement(By.id("gender-male")).click();
       boolean maleRadioBtn = driver.findElement(By.id("gender-male")).isSelected();
       Assertions.assertTrue(maleRadioBtn,"male radio button is clicked");

       driver.findElement(By.id("FirstName")).sendKeys("test");
       driver.findElement(By.id("LastName")).sendKeys("user");
       driver.findElement(By.id("Email")).sendKeys("testuser1@nop.com");
       driver.findElement(By.id("Password")).sendKeys("testing");
       driver.findElement(By.id("ConfirmPassword")).sendKeys("testing");
       driver.findElement(By.id("register-button")).click();
      actualRegisterSuccessMsg = driver.findElement(By.className("register-button")).getText();

    }


    @AfterAll
    public static void tearDown()
    {
       driver.quit();
    }
}
