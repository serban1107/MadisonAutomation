import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class CheckoutPage extends BasePage {
public WebDriverWait wait;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);

    }
    @FindBy(xpath = "//a[text()='Food']")
    private WebElement foodMenu;
    @FindBy(css = ".product-info button")
    private WebElement addToCart;
    @FindBy(id = "city")
    private WebElement cityCart;
    @FindBy(id = "postcode")
    private WebElement postCode;
    @FindBy(id = "region_id")
    public WebElement regionCart;
    @FindBy(css = ".method-checkout-cart-methods-onepage-bottom button")
    private WebElement procedToCheckout;
    @FindBy(id = "onepage-guest-register-button")
    private WebElement guest;
    @FindBy(id = "ul:nth-child(2) .name-lastname")
    private WebElement selector;
    @FindBy(id = "billing:firstname")
    public WebElement firstName;
    @FindBy(id = "Test")
    private WebElement firstName1;
    @FindBy(id = "billing:middlename")
    private WebElement middleName;
    @FindBy(id = "billing:lastname")
    public WebElement billingLastName;
    @FindBy(id = "billing:company")
    public WebElement billingCompany;
    @FindBy(id = "billing:email")
    public WebElement billingEmail;
    @FindBy(id = "billing:street1")
    public WebElement billingStreet1;
    @FindBy(id = "billing:street2")
    private WebElement billingStreet2;
    @FindBy(id = "billing:city")
    public WebElement billingCity;
    @FindBy(id = "billing:region_id")
    public WebElement billingRegionId;
    @FindBy(id = "billing:postcode")
    public WebElement billingPostCode;
    @FindBy(id = "billing:telephone")
    public WebElement billingTelephone;
    @FindBy(css = "[for = 'billing:use_for_shipping_yes']")
    public WebElement shippingYesButton;
    @FindBy(css = "#billing-buttons-container button")
    private WebElement billingButtonContainer;
    @FindBy(css = "#shipping-method-buttons-container button")
    public WebElement shippingButton;
    @FindBy(css = "#payment-buttons-container button")
    public WebElement paymentButton;
    @FindBy(css = ".btn-checkout")
    public WebElement checkoutButton;
    @FindBy(css = ".sub-title")
    public WebElement subTitleButton;

//Nou
    @FindBy(css = ".product-cart-actions input")
    private WebElement quantity;
    @FindBy(css = ".product-cart-actions button")
    private WebElement updateCartButton;

    @FindBy(id = "advice-required-entry-billing:firstname")
    public WebElement requiredFirstName;
    @FindBy(id = "advice-required-entry-billing:lastname")
    public WebElement requiredLastName;
    @FindBy(id = "advice-required-entry-billing:street1")
    public WebElement requiredAddress;
    @FindBy(id = "advice-required-entry-billing:email")
    public WebElement requiredEmail;
    @FindBy(id = "advice-required-entry-billing:city")
    public WebElement requiredCity;
    @FindBy(id = "advice-validate-select-billing:region_id")
    public WebElement requiredRegion_id;
    @FindBy(id = "advice-required-entry-billing:postcode")
    public WebElement requiredPostCode;
    @FindBy(id = "advice-required-entry-billing:telephone")
    public WebElement requiredTelephone;

    public void getFoodMenu() { foodMenu.click();  }
    public void clickAddToCart() { addToCart.click();  }
    public void setCityCart(String city) { cityCart.sendKeys(city); }
    public void setPostCode(String postcode) { postCode.sendKeys("12345"); }
    public void selectRegionCart() { regionCart.click(); }
    public void clickProcedToCheckout() { procedToCheckout.click(); }
    public void clickGuest() { guest.click(); }
    public void clickSelector() { selector.click(); }
    public void setFirstName() { firstName.sendKeys("Test"); }
    public void clickFirstName1() { firstName1.click(); }
//    public void clickMiddleName() { middleName.click(); }
    public void setBillingLastName() { billingLastName.sendKeys("Test3"); }
    public void setBillingCompany() { billingCompany.sendKeys("Test5");  }
    public void setBillingEmail() {
        billingEmail.sendKeys("asdf@example.com");  }
    public void setBillingStreet1() {
        billingStreet1.sendKeys("adresa mea");  }
    public void setBillingStreet2() {
        billingStreet2.sendKeys("adresa mea 2"); }
    public void setBillingCity() { billingCity.sendKeys("Alabama City"); }
    public void setBillingRegionId() {  billingRegionId.click(); }
    public void setBillingPostCode() { billingPostCode.sendKeys("12345"); }
    public void setBillingTelephone() { billingTelephone.sendKeys("0777777777"); }
    public void clickBillingButtonContainer() { billingButtonContainer.click(); }
    public void clickShippingButton() { shippingButton.click(); }
    public void clickPaymentButton() { paymentButton.click(); }
    public void clickCheckoutButton() { checkoutButton.click(); }
    public void clickSubTitleButton() { subTitleButton.click(); }

    public void addItemYoCart() {
        getFoodMenu();
        clickAddToCart();
    }
    public void preliminaryInfo() {
            setCityCart("Alabama");
            setPostCode("12345");
            selectOption(regionCart,  "Alabama");
            clickProcedToCheckout();
    }
    public void guest() {
        clickGuest();
    }
    public void fillInMandatoryFields() {
        setFirstName();
        setBillingLastName();
        setBillingCompany();
        setBillingEmail();
        setBillingStreet1();
        setBillingStreet2();
        setBillingCity();
        setBillingRegionId();
        selectOption(billingRegionId,  "Alabama");
        setBillingPostCode();
        setBillingTelephone();
    }
    public void checkoutContinueButtons() {
        wait.until(ExpectedConditions.elementToBeClickable(shippingYesButton));
        assertEquals("Ship to this address", shippingYesButton.getText());
        clickBillingButtonContainer();
        clickWhenReady(shippingButton);
        clickWhenReady(paymentButton);
        clickWhenReady(checkoutButton);
    }
    public void clickWhenReady(WebElement locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
    public void assertTextWhenReady(WebElement locator, String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(locator, expectedText));
        } catch (Exception e){
            System.out.println("Element or text is not visible or incorrect");
        }
        assertEquals(expectedText, locator.getText());
    }

//Nou
    public void modifyQuantity() {
        quantity.clear();
        quantity.sendKeys("3");
        updateCartButton.click();
    }
    public void fillMandatoryFieldsExcept(WebElement fieldToSkip) {
        addItemYoCart();
        preliminaryInfo();
        guest();
        fillInMandatoryFields();
        fieldToSkip.clear();
        billingButtonContainer.click();

    }
    public void fillMandatoryFieldsExceptSelect(WebElement fieldToSkip) {
        addItemYoCart();
        preliminaryInfo();
        guest();
        fillInMandatoryFields();
        selectOption(fieldToSkip, "Please select region, state or province");
        billingButtonContainer.click();
    }
    //Vlad varianta1
//    public void checkIfCheckoutFieldIsMandatory(WebElement locator) throws InterruptedException {
//        addItemToCart();
//        addPreliminaryInfo();
//        clickBtnRegister();
//        fillMandatoryFields();
//        locator.clear();
//        clickWhenReady(billingButton);
//        WebElement target = locator.findElement(By.xpath(".//following-sibling::div"));
//        assertWhenReady(target, "This is a required field.");
//    }
    //Vlad varianta2
//    public void checkIfCheckoutSelectIsMandatory(WebElement locator) throws InterruptedException {
//        addItemToCart();
//        addPreliminaryInfo();
//        clickBtnRegister();
//        fillMandatoryFields();
//        locator.findElement(By.xpath(".//option")).click();
//        clickWhenReady(billingButton);
//        WebElement target = locator.findElement(By.xpath(".//following-sibling::div"));
//        assertWhenReady(target, "Please select an option.");
//    }




    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }
    //     driver.findElement(By.id("billing:postcode")).sendKeys("12345");
//    driver.findElement(By.id("billing:telephone")).sendKeys("0777777777");
//    driver.findElement(By.cssSelector("#billing-buttons-container button")).click();

//    public void selectOption1(WebElement element1, String option1) {
//        Select optionSelect = new Select(element1);
//        optionSelect.selectByVisibleText(option1);
//    }
//    driver.findElement(By.id("billing:lastname")).sendKeys("Test3");
//    driver.findElement(By.id("billing:company")).sendKeys("Test5");
//    driver.findElement(By.id("billing:email")).sendKeys("asdf@example.com");
//    driver.findElement(By.id("billing:street1")).sendKeys("adresa mea");
//    driver.findElement(By.id("billing:street2")).sendKeys("adresa mea 2");
//    driver.findElement(By.id("billing:city")).sendKeys("Alabama City");
//    driver.findElement(By.id("billing:region_id")).click();
}
//{
//        WebElement dropdown = driver.findElement(By.id("billing:region_id"));
//        dropdown.findElement(By.xpath("//option[. = 'Alabama']")).click();
//        }
//    driver.findElement(By.cssSelector("#shipping-method-buttons-container button")).click();
//    driver.findElement(By.cssSelector("#payment-buttons-container button")).click();
//    driver.findElement(By.cssSelector(".btn-checkout")).click();
//    driver.findElement(By.cssSelector(".sub-title")).click();