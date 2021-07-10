package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NovoProdutoPage extends BasePage {
    @FindBy(id = "produtonome")
    private WebElement nome;
    @FindBy(id = "produtovalor")
    private WebElement valor;
    @FindBy(id = "produtocores")
    private WebElement cores;
    @FindBy(css = "button[type='submit'")
    private WebElement submitBtn;

    public NovoProdutoPage(WebDriver browser) {
        super(browser);
    }

    public NovoProdutoPage informarNomeProduto(String produtoNome) {
        nome.sendKeys(produtoNome);

        return this;
    }

    public NovoProdutoPage informarValorProduto(String produtoValor) {
        valor.sendKeys(produtoValor);

        return this;
    }

    public NovoProdutoPage informarCoresProduto(String produtoCores) {
        cores.sendKeys(produtoCores);

        return this;
    }

    private void submeterNovoItem() {
        submitBtn.click();
    }

    public ListaProdutosPage submeterNovoItemComErro() {
        submeterNovoItem();
        return new ListaProdutosPage(browser);
    }

    public EdicaoProdutoPage submeterNovoItemComSucesso() {
        submeterNovoItem();
        return new EdicaoProdutoPage(browser);
    }
}
