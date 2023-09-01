package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaSignIn {

    //Localizamos los elementos
    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
    private WebElement inputPassword;
    @FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
    private WebElement btnLogin;
    @FindBy(xpath = "//span[contains(text(), 'Welcome, herber gambon!')]")
    private WebElement msjInicioExitoso;

    //Interactuamos con los elementos de la pagina
    private void escribirEmail(String email) {
        inputEmail.sendKeys(email);
    }

    private void escribirPassword(String password) {
        inputPassword.sendKeys(password);
    }

    private void iniciarSesion() {
        btnLogin.click();
    }
    private void verificarInicioSesion(String mensajeEsperado) {
        String msjInicioExitosoText = msjInicioExitoso.getText();
        Assert.assertEquals(msjInicioExitosoText, mensajeEsperado);

    }
    //Metodo para hacer autenticacion en la pagina
    public void autenticarse(String email, String password) {
        escribirEmail(email);
        escribirPassword(password);
        iniciarSesion();
    }
    //Metodo para verificar mensaje despues del inicio de sesion
    public void verificarMsjInicioSesionExitosa(String mensaje){
        verificarInicioSesion(mensaje);
    }
    //Constructor de la clase y se inicializan los elementos de esta pagina
    public PaginaSignIn(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
