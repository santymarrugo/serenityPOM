package pruebas;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pageobjects.*;


public class BaseTestSuite {
    //Instancia del driver
    WebDriver edgeDriver;
    //Instancias de todas las paginas
    PaginaPrincipal paginaPrincipal;
    PaginaSignIn paginaSignIn;
    PaginaProductos paginaProductos;
    PaginaAgregarAlCarrito paginaAgregarAlCarrito;
    PaginaFinalizarPago paginaFinalizarPago;

    //Todas las paginas creadas en nuestro proyecto se inicializan
    // se instancias los objetos de las clases de las paginas
    private void inicializarPaginas(WebDriver driver) {
        paginaPrincipal = new PaginaPrincipal(edgeDriver);
        paginaSignIn = new PaginaSignIn(edgeDriver);
        paginaProductos = new PaginaProductos(edgeDriver);
        paginaAgregarAlCarrito = new PaginaAgregarAlCarrito(edgeDriver);
        paginaFinalizarPago = new PaginaFinalizarPago(edgeDriver);
    }
    @Before
    public void abrirDriver() {
        //Ruta donde se encuentra el ejecutable del driver de Edge
        System.setProperty("webdriver.edge.driver", "src\\main\\resources\\msedgedriver.exe");

        //Nueva instancia de Edge
        edgeDriver = new EdgeDriver();
        edgeDriver.manage().window().maximize();

        inicializarPaginas(edgeDriver);

    }

    @After
    public void cerrar_driver() {
        //Cerrar ventana, apagar el driver
        // Si el driver el nulo nunca se inicializó y no se puede cerrar
        if (edgeDriver != null) {
            edgeDriver.quit();
        }
    }
}
