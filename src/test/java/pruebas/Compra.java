package pruebas;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Compra extends BaseTestSuite {


    //Metodo para simular una espera del usuario mientras espera que el contenido cargue
    public void esperar() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void hacer_una_compra() {
        //Abrimos la URL de la pagina
        edgeDriver.get("https://magento.softwaretestingboard.com/");

        paginaPrincipal.irBotonSingIn();
        paginaSignIn.autenticarse("herbergambon@yopmail.com", "12345ABC#");
        esperar();
        paginaSignIn.verificarMsjInicioSesionExitosa("Welcome, herber gambon!");
        paginaProductos.irACategoriaJackets();
        esperar();
        paginaAgregarAlCarrito.agregarCarrito1();
        esperar();
        paginaAgregarAlCarrito.ClbtnTallaS();
        paginaAgregarAlCarrito.ClbtnColor();
        paginaAgregarAlCarrito.ClbtnAddToCart2();
        esperar();
        paginaAgregarAlCarrito.msjProductoAgregadoExito("You added Kenobi Trail Jacket to your shopping cart.");
        //Verificamos que se haya agregado el producto
        //String msjAgregadoExitoso = edgeDriver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        //Assert.assertEquals("You added Kenobi Trail Jacket to your shopping cart.", msjAgregadoExitoso);
        //Procedemos a iniciar el proceso de pago
        WebElement btnCart = edgeDriver.findElement(By.xpath("//a[@class='action showcart']"));
        btnCart.click();
        //Boton checkout
        WebElement btnCheckout = edgeDriver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']"));
        btnCheckout.click();
        //Espera de 3 segundos
        esperar();
        esperar();
        //esperar();
        //Boton Next
        WebElement btnNext = edgeDriver.findElement(By.xpath("//span[contains(text(),'Next')]"));
        btnNext.click();
        esperar();
        esperar();
        //Boton Place Order
        WebElement btnPlaceOrder = edgeDriver.findElement(By.xpath("//span[contains(text(),'Place Order')]"));
        btnPlaceOrder.click();
        esperar();
        //Mensaje de pedido exitoso
        String msjPedidoExitoso = edgeDriver.findElement(By.xpath("//span[contains(text(),'Thank you for your purchase!')]")).getText();
        Assert.assertEquals("Thank you for your purchase!", msjPedidoExitoso);

    }

}
