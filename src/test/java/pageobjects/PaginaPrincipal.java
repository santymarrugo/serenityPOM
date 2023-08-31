package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaPrincipal {

    //Localizamos los elementos
    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    private WebElement botonSingIn;

    //Interactuamos con los elementos de la pagina
    public void irBotonSingIn() {
        botonSingIn.click();
    }
    //Constructor de la clase y se inicializan los elementos de esta pagina
    public PaginaPrincipal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
