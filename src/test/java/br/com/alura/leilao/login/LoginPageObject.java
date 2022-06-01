package br.com.alura.leilao.login;

import org.openqa.selenium.By;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.lance.LancePageObjetct;
import br.com.alura.leilao.leilao.LeilaoPageObjetct;


// Aqui fica a api do Selenium
public class LoginPageObject extends PageObject {

    private static final String URL_LOGIN = "http://localhost:8080/login";
    private static final String URL_LEILOES = "http://localhost:8080/leiloes/2";
    private static final String URL_HOME = "http://localhost:8080/leiloes";

    public LoginPageObject () {
       
        super(null);
        this.browser.navigate().to(URL_LOGIN);

    }

   

    public LeilaoPageObjetct preecheFormularioDeLogin(String username, String password) {

        browser.findElement(By.name("username")).sendKeys(username);
        browser.findElement(By.name("password")).sendKeys(password);

        return new LeilaoPageObjetct(browser);
       
    }

    public LancePageObjetct efetuarLogin(String username, String password) {
        this.preecheFormularioDeLogin(username, password);
        browser.findElement(By.id("button")).click();

        return new LancePageObjetct(browser);
    }

    
    
    public void clicarNoBotao(String id) {
        browser.findElement(By.id(id)).click();
       
    }

    public void clicarNoBotaoLogarLeiloesPageObject() {
        
        browser.findElement(By.id("button")).click();
        
       
    }

    public boolean isPaginaDeLogin() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public Object getNomeUsuarioLogado() {

        return browser.findElement(By.id("usuario-logado")).getText();
    }

    public Object menssagensDeErroExibidaEmCamposVazios() {
        return browser.findElement(By.id("mensagem-alert")).getText();
    }

    public void tempoDeEspera(int tempo) throws InterruptedException {
        Thread.sleep(tempo);;
       
    }

    public void clicarNaLogoLeilao() {
        browser.findElement(By.id("leilao")).click();
    }

    public boolean contemAhInformacaoNaPagina(String mensagem) {
        return browser.getPageSource().contains(mensagem);
    }

    public void navegaParaUrlLeiloes() {
        browser.navigate().to(URL_LEILOES);
    }



    public boolean paginaAtual() {
        return browser.getCurrentUrl().equals(URL_HOME);
    }



   



    










  

    

}
