package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListaProdutosPage {
    private WebDriver browser;

    @FindBy(linkText = "ADICIONAR PRODUTO")
    private WebElement addProdutoBtn;
    @FindBy(css = ".toast.rounded")
    private WebElement mensagemToast;

    public ListaProdutosPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public NovoProdutoPage acessarPaginaNovoProduto() {
        addProdutoBtn.click();

        return new NovoProdutoPage(browser);
    }

    public String capturarMensagem() {
        return mensagemToast.getText();
    }
}
