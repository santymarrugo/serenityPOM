package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaProductos {

    WebDriver driver;

    //Localizamos los elementos
    @FindBy(xpath = "//span[normalize-space()='Men']")
    WebElement btnCategoryMen;
    @FindBy(xpath = "//a[@id='ui-id-17']//span[contains(text(),'Tops')]")
    WebElement btnSubCategoryTops;
    @FindBy(xpath = "//a[@id='ui-id-19']//span[contains(text(),'Jackets')]")
    WebElement btnJackets;

    //Se crea una accion y se interactua con el elemento
    public void irACategoriaJackets(){
        Actions accion = new Actions(this.driver);
        accion.moveToElement(btnCategoryMen).moveToElement(btnSubCategoryTops).moveToElement(btnJackets).click().build().perform();
    }
    //Constructor de la clase y se inicializan los elementos de esta pagina
    public PaginaProductos (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
