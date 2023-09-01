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
        //Se ejecutan los metodos de las paginas del sitio
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
        paginaFinalizarPago.ClbtnCart();
        paginaFinalizarPago.ClbtnCheckout();
        esperar();
        esperar();
        paginaFinalizarPago.ClbtnNext();
        esperar();
        esperar();
        paginaFinalizarPago.ClbtnPlaceOrder();
        esperar();
        paginaFinalizarPago.msjPedidoFinalizadoConExito("Thank you for your purchase!");
    }
}
