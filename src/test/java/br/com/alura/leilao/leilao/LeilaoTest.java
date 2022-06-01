package br.com.alura.leilao.leilao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPageObject;

public class LeilaoTest {

    private LeilaoPageObjetct paginaDeLeiloes;
    private LoginPageObject paginaDeLogin;

 
  
    @BeforeEach
    public void inicializar() {
        this.paginaDeLogin = new LoginPageObject();
        this.paginaDeLeiloes = paginaDeLogin.preecheFormularioDeLogin("ricardo", "pass");
        this.paginaDeLeiloes.clicarNoBotao("button");
        paginaDeLeiloes.clicarNoBotao("novo_leilao_link");
    }

    @AfterEach
    public void finalizar() {
        this.paginaDeLeiloes.fechar();
    }

    @Test
    public void deveriaCadastrarNovoItemDeLeilao() throws InterruptedException {
      
        String hora = LocalDateTime.now().format(DateTimeFormatter.ofPattern(" 'as' hh:mm:ss a")); 
        String nome = "Micro Computador2 " + hora;
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
        String valorInicial = "2500.00";
        this.paginaDeLeiloes.preencheFormularioDeCadastroItemLeilao(nome, valorInicial, data);
        paginaDeLogin.tempoDeEspera(5000);
    }

}
