package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver browser;

    @FindBy(id = "usuario")
    private WebElement usr;
    @FindBy(id = "senha")
    private WebElement snh;
    @FindBy(css = "button[type='submit'")
    private WebElement submitBtn;

    public LoginPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public LoginPage informarUsuario(String usuario) {
        usr.sendKeys(usuario);

        return this;
    }

    public LoginPage infomarSenha(String senha) {
        snh.sendKeys(senha);

        return this;
    }

    public ListaProdutosPage submeterLogin() {
        submitBtn.click();

        return new ListaProdutosPage(browser);
    }
}
