package br.com.alura.leilao.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.PageObject;

public class LeilaoPageObjetct extends PageObject{
    
    public LeilaoPageObjetct (WebDriver browser) {
        super(browser);
    }

    public void fechar() {
        this.browser.quit();
    }

    public void clicarNoBotao(String id) {

        this.browser.findElement(By.id(id)).click();
    }

    public boolean contemAhInformacaoNaPagina(String id) {
        return browser.getPageSource().contains(id);
    }

    public void darLance(String valor) {
        this.browser.findElement(By.id("valor")).sendKeys(valor);
    }

    public Object isAhMensagemExibida() {
        return browser.findElement(By.id("mensagem")).getText();
    }

    public Object usuarioLogado() {
        return browser.findElement(By.id("usuario-logado")).getText();
    }

    public void preencheFormularioDeCadastroItemLeilao(String nome, String valorInicial, String data) {
        this.browser.findElement(By.id("nome")).sendKeys(nome);
        this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
        this.browser.findElement(By.id("dataAbertura")).sendKeys(data);
        this.browser.findElement(By.id("button-submit")).click();
    }

    public Object isLeilaoCadastrado(String nome, String valorInicial, String data) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		
		return colunaNome.getText().equals(nome) && colunaDataAbertura.getText().equals(data) && colunaValorInicial.getText().equals(valorInicial);
    }

    
}
