import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class LoginPage extends BasePage {
public WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);

    }
    @FindBy(css = ".skip-account span.label")
    private WebElement account;
    @FindBy(css = "#header-account first>a")
    private WebElement myAccount;
    @FindBy(id = "#email")
    private WebElement email;
    @FindBy(id = "#pass")
    private WebElement pass;
    @FindBy(id = "#send2")
    private WebElement login;


    public void clickAccount() {
        account.click();
        myAccount.click();
        email.sendKeys("bel_serban@yaho.ro");
        pass.sendKeys("1111111");
        login.click();
    }
}
