
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class CheckoutTest extends Hooks {

  public CheckoutPage checkoutPage;
  public WebDriverWait wait;

  @Before
  public void SetuoPageObject() {
checkoutPage = new CheckoutPage(driver);
wait = new WebDriverWait(driver, 10);
  }


  @Test
  public void checkoutAsAGuest() throws InterruptedException {

    checkoutPage.addItemYoCart();
    checkoutPage.preliminaryInfo();
    checkoutPage.guest();
    checkoutPage.assertTextWhenReady(checkoutPage.shippingYesButton, "Ship to this address");
    checkoutPage.fillInMandatoryFields();
    checkoutPage.checkoutContinueButtons();
    checkoutPage.assertTextWhenReady(checkoutPage.subTitleButton, "THANK YOU FOR YOUR PURCHASE!" );


//    {
//      WebElement element = driver.findElement(By.cssSelector(".sub-title"));
//    }
//    wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.subTitleButton));
//    checkoutPage.clickSubTitleButton();
  }



@Test
public void checkoutWithUpdatedQuantityTest(){

  checkoutPage.addItemYoCart();
//Nou
  checkoutPage.modifyQuantity();

  checkoutPage.preliminaryInfo();
  checkoutPage.guest();
  checkoutPage.assertTextWhenReady(checkoutPage.shippingYesButton, "Ship to this address");
  checkoutPage.fillInMandatoryFields();
  checkoutPage.checkoutContinueButtons();
  checkoutPage.assertTextWhenReady(checkoutPage.subTitleButton, "THANK YOU FOR YOUR PURCHASE!" );
}

//@Test
//public void checkoutAsALoggedInUser() {
//
//}


@Test
public void checkFirstNameMandatoryFieldsTest() {
  checkoutPage.fillMandatoryFieldsExcept(checkoutPage.firstName);
  checkoutPage.assertTextWhenReady(checkoutPage.requiredFirstName, "This is a required field.");
}
  @Test
  public void checkLastNameMandatoryFieldsTest() {
    checkoutPage.fillMandatoryFieldsExcept(checkoutPage.billingLastName);
    checkoutPage.assertTextWhenReady(checkoutPage.requiredLastName, "This is a required field.");
  }
  @Test
  public void checkAddressMandatoryFieldsTest() {
    checkoutPage.fillMandatoryFieldsExcept(checkoutPage.billingStreet1);
    checkoutPage.assertTextWhenReady(checkoutPage.requiredAddress, "This is a required field.");
  }
  @Test
  public void checkEmailMandatoryFieldsTest() {
    checkoutPage.fillMandatoryFieldsExcept(checkoutPage.billingEmail);
    checkoutPage.assertTextWhenReady(checkoutPage.requiredEmail, "This is a required field.");
  }
  @Test
  public void checkCityMandatoryFieldsTest() {
    checkoutPage.fillMandatoryFieldsExcept(checkoutPage.billingCity);
    checkoutPage.assertTextWhenReady(checkoutPage.requiredCity, "This is a required field.");
  }
  @Test
  public void checkRegionIdMandatoryFieldsTest() {
    checkoutPage.fillMandatoryFieldsExceptSelect(checkoutPage.billingRegionId);
    checkoutPage.assertTextWhenReady(checkoutPage.requiredRegion_id, "Please select an option.");
  }
  @Test
  public void checkPostCodeMandatoryFieldsTest() {
    checkoutPage.fillMandatoryFieldsExcept(checkoutPage.billingPostCode);
    checkoutPage.assertTextWhenReady(checkoutPage.requiredPostCode, "This is a required field.");
  }
  @Test
  public void checkTelephoneMandatoryFieldsTest() {
    checkoutPage.fillMandatoryFieldsExcept(checkoutPage.billingTelephone);
    checkoutPage.assertTextWhenReady(checkoutPage.requiredTelephone, "This is a required field.");
  }



}

