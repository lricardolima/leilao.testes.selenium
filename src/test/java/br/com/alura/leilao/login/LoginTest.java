package br.com.alura.leilao.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


// Aqui fica a Api do Junit
public class LoginTest {

    private LoginPageObject paginaDeLogin;
   
    @BeforeEach
    public void inicializar() {
       this.paginaDeLogin = new LoginPageObject();
       paginaDeLogin.efetuarLogin("ricardo", "pass");
       
    }  

    @AfterEach
	public void finalizar() {
		this.paginaDeLogin.fechar();
	}
   

    @Test
    public void DeveriaEfetuarLoginComDadosValidos() throws InterruptedException {
       
        paginaDeLogin.tempoDeEspera(3000);
        assertFalse(paginaDeLogin.isPaginaDeLogin());
        assertEquals("ricardo", paginaDeLogin.getNomeUsuarioLogado());
   
    }

    @Test
    public void ExibirMenssagensDeErroEmCamposVazios() throws InterruptedException {

        paginaDeLogin.clicarNoBotao("sair");
        paginaDeLogin.clicarNoBotao("entrar");
        paginaDeLogin.clicarNoBotao("button");
        assertEquals("Usuário e senha inválidos.", paginaDeLogin.menssagensDeErroExibidaEmCamposVazios());
        

    }

    @Test
    public void LogarNoSistemaComDadosInvalidos() throws InterruptedException {

        paginaDeLogin.clicarNoBotao("sair");
        paginaDeLogin.clicarNoBotao("entrar");
        paginaDeLogin.efetuarLogin("ricardo", "ricardo");
        assertFalse(paginaDeLogin.isPaginaDeLogin());
        assertEquals( "Usuário e senha inválidos.", paginaDeLogin.menssagensDeErroExibidaEmCamposVazios()); 
       
        
    }

    @Test
    public void DeveriaSerDirecionadoAhPaginaInicialDeLeiloes() throws InterruptedException {
        
       
        paginaDeLogin.clicarNaLogoLeilao();
        assertFalse(paginaDeLogin.isPaginaDeLogin());
        
        assertTrue(paginaDeLogin.contemAhInformacaoNaPagina("Leilões cadastrados"));
       

    }

    @Test
    public void deveriaSairDaPaginaListaDeLeiloes() {
        
        assertTrue(paginaDeLogin.paginaAtual());
        assertTrue(paginaDeLogin.contemAhInformacaoNaPagina("Novo Leilão"));
        paginaDeLogin.clicarNoBotao("sair");
        assertFalse(paginaDeLogin.contemAhInformacaoNaPagina("Novo Leilão"));
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() throws InterruptedException {

        paginaDeLogin.clicarNoBotao("sair");
        paginaDeLogin.navegaParaUrlLeiloes();
       
        assertTrue(paginaDeLogin.isPaginaDeLogin());
        assertFalse(paginaDeLogin.contemAhInformacaoNaPagina("Dados do Leilão"));
        
    }

}
