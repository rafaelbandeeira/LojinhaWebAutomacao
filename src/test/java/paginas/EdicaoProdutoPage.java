package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EdicaoProdutoPage {
    private WebDriver browser;

    @FindBy(css = ".toast.rounded")
    private WebElement mensagemToast;

    public EdicaoProdutoPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public String capturarMensagem() {
        return mensagemToast.getText();
    }
}
