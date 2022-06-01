package br.com.alura.leilao.lance;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPageObject;

public class LanceTest {

    private LancePageObjetct paginaDeLances;
    private LoginPageObject paginaDeLogin;
    @BeforeEach
    public void inicializar() {
        this.paginaDeLogin = new LoginPageObject();
        this.paginaDeLances = paginaDeLogin.efetuarLogin("ricardo", "pass");
        paginaDeLances.clicarNoBotao("dar-lance");
    }

    @AfterEach
    public void finalizar() {
        this.paginaDeLances.fechar();
    }

    @Test
    public void deveriaIrParaPaginaDeLancesEhDarLance() throws InterruptedException {
        
        assertTrue(paginaDeLances.contemAhInformacaoNaPagina("Dados do Leilão"));
        paginaDeLances.darLance("503");
        paginaDeLances.clicarNoBotao("btnDarLance");
        paginaDeLogin.tempoDeEspera(5000);
        assertEquals("Lance adicionado com sucesso!", paginaDeLances.isAhMensagemExibida());

    }

    @Test
    public void validarMensagensDeCamposNaoPreenchidos() {
        paginaDeLances.clicarNoBotao("btnDarLance");
        assertEquals("não deve ser nulo", paginaDeLances.isAhMensagemExibida());
    }

    @Test
    public void validarMensagensDeCamposPreenchidosComZero() {
        paginaDeLances.darLance("000");
        paginaDeLances.clicarNoBotao("btnDarLance");
        assertEquals("deve ser maior que ou igual a 0.1", paginaDeLances.isAhMensagemExibida());
    }

}
