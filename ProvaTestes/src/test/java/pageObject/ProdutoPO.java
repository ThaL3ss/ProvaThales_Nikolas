package pageObject;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO {

    @FindBy(id="btn-adicionar")
    public WebElement botaoAdicionar;

    @FindBy(id="codigo")
    public WebElement inputCodigo;

    @FindBy(id="nome")
    public WebElement inputNome;

    @FindBy(id="quantidade")
    public WebElement inputQuantidade;

    @FindBy(id="valor")
    public WebElement inputValor;

    @FindBy(id="data")
    public WebElement inputData;

    @FindBy(id="btn-salvar")
    public WebElement botaoSalvar;

    @FindBy(id="btn-sair")
    public WebElement botaoSair;
    
    @FindBy(css = "table tbody")
    public WebElement tabelaProdutos;

    @FindBy(css="div.alert>span#mensagem")
    public WebElement spanMensagemErro;

    public ProdutoPO(WebDriver driver) {
        super(driver);
    }
    
   

    public void abrirModalCriarProduto() {
        botaoAdicionar.click();
    }

    public void preencherProduto(String codigo, String nome, String quantidade, String valor, String data) {
        inputCodigo.clear();        inputCodigo.sendKeys(codigo);
        inputNome.clear();          inputNome.sendKeys(nome);
        inputQuantidade.clear();    inputQuantidade.sendKeys(quantidade);
        inputValor.clear();         inputValor.sendKeys(valor);
        inputData.clear();          inputData.sendKeys(data + Keys.TAB);
    }

    public void salvar() {
        botaoSalvar.click();
    }

    public boolean mensagemObrigatoriaVisivel() {
        return spanMensagemErro.isDisplayed();
    }

    public String getMensagemErro() {
        return spanMensagemErro.getText();
    }
    public void sair() {
    	botaoSair.click();
    }
    
 // Verifica se algum produto foi cadastrado na tabela
    public boolean produtoExisteNaTabela(String codigo) {
        return tabelaProdutos.getText().contains(codigo);
    }


}




 