package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListaProdutosPage extends BasePage {

    @FindBy(linkText = "ADICIONAR PRODUTO")
    private WebElement addProdutoBtn;

    public ListaProdutosPage(WebDriver browser) {
        super(browser);
    }

    public NovoProdutoPage acessarPaginaNovoProduto() {
        addProdutoBtn.click();

        return new NovoProdutoPage(browser);
    }

    public String lerMensagem() {
        return capturarMensagem();
    }
}
