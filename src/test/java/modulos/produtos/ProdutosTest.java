package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("testes web do modulo de produtos")
public class ProdutosTest {
    private WebDriver browser;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "/Users/rafaelds/drivers/chromedriver91/chromedriver");
        browser = new ChromeDriver();

        browser.manage().window().maximize();

        browser.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(3));

        browser.get("http://165.227.93.41/lojinha-web/v2");
    }

    @Test
    public void testNaoEPermitidoRegistrarProdutosComValorIgualAZero() {
        String mensagemToast = new LoginPage(browser)
                .informarUsuario("admin")
                .infomarSenha("admin")
                .submeterLogin()
                .acessarPaginaNovoProduto()
                .informarNomeProduto("Produto Teste")
                .informarValorProduto("000")
                .informarCoresProduto("preto,azul")
                .submeterNovoItemComErro()
                .capturarMensagem();

        Assertions.assertEquals(
                "O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",
                mensagemToast
        );
    }

    @Test
    public void testNaoEPermitidoRegistrarProdutosComValorMaiorQueSeteMil() {
        String mensagemToast = new LoginPage(browser)
                .informarUsuario("admin")
                .infomarSenha("admin")
                .submeterLogin()
                .acessarPaginaNovoProduto()
                .informarNomeProduto("Produto Teste 2")
                .informarValorProduto("700001")
                .informarCoresProduto("rosa, prata")
                .submeterNovoItemComErro()
                .capturarMensagem();

        Assertions.assertEquals(
                "O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",
                mensagemToast
        );
    }

    @Test
    public void testCriarProdutoNasFaixasValidas() {
        String mensagemToast = new LoginPage(browser)
                .informarUsuario("admin")
                .infomarSenha("admin")
                .submeterLogin()
                .acessarPaginaNovoProduto()
                .informarNomeProduto("Produto Teste 3")
                .informarValorProduto("40000")
                .informarCoresProduto("rosa, prata")
                .submeterNovoItemComSucesso()
                .capturarMensagem();

        Assertions.assertEquals(
                "Produto adicionado com sucesso",
                mensagemToast
        );
    }

    @Test
    public void testCriarProdutoComValorDeSeteMil() {
        String mensagemToast = new LoginPage(browser)
                .informarUsuario("admin")
                .infomarSenha("admin")
                .submeterLogin()
                .acessarPaginaNovoProduto()
                .informarNomeProduto("Produto Teste 3")
                .informarValorProduto("700000")
                .informarCoresProduto("rosa, prata")
                .submeterNovoItemComSucesso()
                .capturarMensagem();

        Assertions.assertEquals(
                "Produto adicionado com sucesso",
                mensagemToast
        );
    }

    @AfterEach
    public void afterEach() {
        // fechar o navegador
        browser.quit();
    }
}
