package paginas;

import org.openqa.selenium.WebDriver;

public class EdicaoProdutoPage extends BasePage {

    public EdicaoProdutoPage(WebDriver browser) {
        super(browser);
    }

    public String lerMensagem() {
        return capturarMensagem();
    }
}
