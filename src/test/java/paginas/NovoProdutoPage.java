package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NovoProdutoPage {
    private WebDriver browser;

    @FindBy(id = "produtonome")
    private WebElement nome;
    @FindBy(id = "produtovalor")
    private WebElement valor;
    @FindBy(id = "produtocores")
    private WebElement cores;
    @FindBy(css = "button[type='submit'")
    private WebElement submitBtn;

    public NovoProdutoPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
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

    public ListaProdutosPage submeterNovoItemComErro() {
        submitBtn.click();

        return new ListaProdutosPage(browser);
    }

    public EdicaoProdutoPage submeterNovoItemComSucesso() {
        submitBtn.click();

        return new EdicaoProdutoPage(browser);
    }
}
