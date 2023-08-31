package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaPrincipal {

    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    private WebElement botonSingIn;

    public void irBotonSingIn() {
        botonSingIn.click();
    }

    public PaginaPrincipal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebDriver inputEmail;
}
