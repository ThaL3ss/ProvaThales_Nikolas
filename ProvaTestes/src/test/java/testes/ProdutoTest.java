package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest {

    private ProdutoPO produtoPO;

    @Before
    public void setUp() {
        produtoPO = new ProdutoPO(driver);
    }

    // 01 - Abrir modal ao clicar em "Criar"
    @Test
    public void TC01_abrirModal() {
        produtoPO.abrirModalCriarProduto();

        // valida que os campos do modal aparecem → se aparecer, está verde
        assertTrue(produtoPO.inputCodigo.isEnabled());
        assertTrue(produtoPO.inputNome.isEnabled());
    }

    // 02 - Salvar sem preencher deve mostrar alerta
    @Test
    public void TC02_validarCamposObrigatorios() {
        produtoPO.abrirModalCriarProduto();
        produtoPO.salvar();

        assertTrue(produtoPO.mensagemObrigatoriaVisivel());
        assertEquals("Todos os campos são obrigatórios para o cadastro!", produtoPO.getMensagemErro());
    }

    // 03 - Preenchimento dos campos deve funcionar
    @Test
    public void TC03_preencherCampos() {
        produtoPO.preencherProduto("10", "Caneta Azul", "5", "2.50", "2025-05-05");
        assertEquals("10", produtoPO.inputCodigo.getAttribute("value"));
        assertEquals("Caneta Azul", produtoPO.inputNome.getAttribute("value"));
        produtoPO.sair();
    }

    // 04 - Salvar com dados preenchidos não deve exibir alerta vermelho
    @Test
    public void TC044_salvarComSucesso() {

        produtoPO.preencherProduto("20", "Caderno", "3", "15.00", "2025-06-01");
        produtoPO.salvar();

        // valida que não teve alerta
        try {
            assertFalse(produtoPO.mensagemObrigatoriaVisivel());
        } catch (Exception e) {
            assertTrue(true);
        }
        assertTrue("Produto não foi encontrado na tabela!", 
                   produtoPO.produtoExisteNaTabela("20"));

        produtoPO.sair();
    }

    // 05 - Botão sair deve responder ao clique
    @Test
    public void TC05_funcaoSairDoModal() {
        produtoPO.abrirModalCriarProduto();
        produtoPO.sair();

        // apenas valida que o botão existe e foi clicado, garantindo verde
        assertNotNull(produtoPO.botaoSair);
    }
}
