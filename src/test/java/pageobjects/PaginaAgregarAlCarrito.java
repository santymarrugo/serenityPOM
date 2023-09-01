package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaAgregarAlCarrito {

    WebDriver driver;
    //Localizamos los elementos
    @FindBy(xpath = "//img[@alt='Kenobi Trail Jacket']")
    WebElement irProductoKenobi;
    @FindBy(xpath = "//li[9]//div[1]//div[1]//div[4]//div[1]//div[1]//form[1]//button[1]//span[1]")
    WebElement btnAddToCart1;
    @FindBy(xpath = "//div[@id='option-label-size-143-item-167']")
    WebElement btnTallaS;
    @FindBy(xpath = "//div[@id='option-label-color-93-item-50']")
    WebElement btnColor;
    @FindBy(xpath = "//span[normalize-space()='Add to Cart']")
    WebElement btnAddToCart2;
    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement msjProductoAgregadoExito;
    //Se crea una accion y se interactua con el elemento
    public void agregarCarrito1(){
        Actions accion = new Actions(this.driver);
        accion.moveToElement(irProductoKenobi).moveToElement(btnAddToCart1).click().build().perform();

    }

    //Interacciones con los botones para agregar al carrito
    public void ClbtnTallaS(){
        btnTallaS.click();
    }
    public void ClbtnColor(){
        btnColor.click();
    }
    public void ClbtnAddToCart2(){
        btnAddToCart2.click();
    }

    public void msjProductoAgregadoExito(String msjEsperado){
        String msjObtenido = msjProductoAgregadoExito.getText();
        Assert.assertEquals(msjEsperado, msjObtenido);
    }
    //Constructor de la clase y se inicializan los elementos de esta pagina
    public PaginaAgregarAlCarrito(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
