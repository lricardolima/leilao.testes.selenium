package br.com.alura.leilao.lance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.PageObject;

public class LancePageObjetct extends PageObject{
    
    public LancePageObjetct (WebDriver browser) {
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

    
}
