package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaFinalizarPago {

    //Localizamos los elementos
    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement btnCart;
    @FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
    WebElement btnCheckout;
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    WebElement btnNext;
    @FindBy(xpath = "//span[contains(text(),'Place Order')]")
    WebElement btnPlaceOrder;
    @FindBy(xpath = "//span[contains(text(),'Thank you for your purchase!')]")
    WebElement msjPedidoFinalizadoConExito;

    //Interactuamos con los elementos
    public void ClbtnCart(){
        btnCart.click();
    }
    public void ClbtnCheckout(){
        btnCheckout.click();
    }
    public void ClbtnNext(){
        btnNext.click();
    }
    public void ClbtnPlaceOrder(){
        btnPlaceOrder.click();
    }

    public void msjPedidoFinalizadoConExito(String msjEsperado){
        String msjObtenido = msjPedidoFinalizadoConExito.getText();
        Assert.assertEquals(msjEsperado, msjObtenido);
    }
    //Constructor de la clase y se inicializan los elementos de esta pagina usando la clase PageFactory
    public PaginaFinalizarPago(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
