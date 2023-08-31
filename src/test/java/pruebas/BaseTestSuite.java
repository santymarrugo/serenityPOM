package pruebas;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pageobjects.PaginaPrincipal;
import pageobjects.PaginaSignIn;

import java.io.*;

public class BaseTestSuite {
    //Instancia del driver
    WebDriver edgeDriver;
    PaginaPrincipal paginaPrincipal;
    PaginaSignIn paginaSignIn;

    private void inicializarPaginas(WebDriver driver) {

        paginaPrincipal = new PaginaPrincipal(edgeDriver);
        paginaSignIn = new PaginaSignIn(edgeDriver);
    }


    @Before
    public void abrirDriver() throws IOException {
        //Ruta donde se encuentra el ejecutable del driver de FireFox
        System.setProperty("webdriver.edge.driver", "src\\main\\resources\\msedgedriver.exe");

        //Nueva instancia de FirefoxDriver
        edgeDriver = new EdgeDriver();
        edgeDriver.manage().window().maximize();

        //Guarda una captura al final del test
        File capturaFinal = ((TakesScreenshot) edgeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(capturaFinal, new File("./images/imagen1.png"));
        inicializarPaginas(edgeDriver);
    }

    @After
    public void cerrar_driver() {
        //Cerrar ventana, apagar el driver
        if (edgeDriver != null) {
            edgeDriver.quit();
        }
    }
}
