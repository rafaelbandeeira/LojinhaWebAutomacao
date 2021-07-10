package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "usuario")
    private WebElement usr;
    @FindBy(id = "senha")
    private WebElement snh;
    @FindBy(css = "button[type='submit'")
    private WebElement submitBtn;

    public LoginPage(WebDriver browser) {
        super(browser);
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
