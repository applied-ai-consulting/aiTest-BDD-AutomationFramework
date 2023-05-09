package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ProductPage extends BaseClass {
    private By addToCartButton = By.id("add-to-cart-button");
    private By quantityInput = By.id("quantity");
    private By deliveryAddressInput = By.id("delivery-address");
    private By paymentInformationInput = By.id("payment-information");
    public void addItemToCart() {
        driver.findElement(addToCartButton).click();
    }
    public void setQuantity(String quantity) {
        driver.findElement(quantityInput).sendKeys(quantity);
    }
    public void setDeliveryAddress(String address) {
        driver.findElement(deliveryAddressInput).sendKeys(address);
    }
    public void setPaymentInformation(String paymentInfo) {
        driver.findElement(paymentInformationInput).sendKeys(paymentInfo);
    }
}