package pruebas;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


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

        /*
        Definimos los elementos Web
        * */
        //Boton SingIn
//        WebElement botonSingIn = edgeDriver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]"));
//        botonSingIn.click();
        //Input email address
        WebElement inputEmail = edgeDriver.findElement(By.xpath("//input[@id='email']"));
        inputEmail.sendKeys("herbergambon@yopmail.com");
        //Input password
        WebElement inputPassword = edgeDriver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']"));
        inputPassword.sendKeys("12345ABC#");
        //Boton iniciar sesion
        WebElement btnLogin = edgeDriver.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]"));
        btnLogin.click();
        esperar();
        //Validamos que se haya iniciado sesion correctamente, verificando el nombre del usuario
        String msjInicioExitoso = edgeDriver.findElement(By.xpath("//span[contains(text(), 'Welcome, herber gambon!')]")).getText();
        Assert.assertEquals("Welcome, herber gambon!", msjInicioExitoso);
        //Boton categoria MEN
        WebElement btnCategoryMen = edgeDriver.findElement(By.xpath("//span[normalize-space()='Men']"));
        //Boton subcategoria Tops
        WebElement btnSubCategoryTops = edgeDriver.findElement(By.xpath("//a[@id='ui-id-17']//span[contains(text(),'Tops')]"));
        //Boton Jackets
        WebElement btnJackets = edgeDriver.findElement(By.xpath("//a[@id='ui-id-19']//span[contains(text(),'Jackets')]"));

        //Crear accion
        Actions accion = new Actions(edgeDriver);
        //Aqui navegamos hasta la categoria Jackets utilizando la libreia Actions
        accion.moveToElement(btnCategoryMen).moveToElement(btnSubCategoryTops).moveToElement(btnJackets).click().build().perform();
        //Producto a comprar Kenobi
        WebElement irProductoKenobi = edgeDriver.findElement(By.xpath("//img[@alt='Kenobi Trail Jacket']"));
        //Ir hasta el producto que se quiere comprar
        //Boton agregar al carrito
        WebElement btnAddToCart1 = edgeDriver.findElement(By.xpath("//li[9]//div[1]//div[1]//div[4]//div[1]//div[1]//form[1]//button[1]//span[1]"));
        //Agregar al carrito
        accion.moveToElement(irProductoKenobi).moveToElement(btnAddToCart1).click().build().perform();
        //Espera de 3 segundos
        esperar();
        //Seleccionamos la talla
        WebElement tallaS = edgeDriver.findElement(By.xpath("//div[@id='option-label-size-143-item-167']"));
        tallaS.click();
        //Seleccionamos el color
        WebElement color = edgeDriver.findElement(By.xpath("//div[@id='option-label-color-93-item-50']"));
        color.click();
        //Boton agregar al carrito 2
        WebElement btnAddToCart2 = edgeDriver.findElement(By.xpath("//span[normalize-space()='Add to Cart']"));
        btnAddToCart2.click();
        //Espera de 3 segundos
        esperar();
        //Verificamos que se haya agregado el producto
        String msjAgregadoExitoso = edgeDriver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        Assert.assertEquals("You added Kenobi Trail Jacket to your shopping cart.", msjAgregadoExitoso);
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
