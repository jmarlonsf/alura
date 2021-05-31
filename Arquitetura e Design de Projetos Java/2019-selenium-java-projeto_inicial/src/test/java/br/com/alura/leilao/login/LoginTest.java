package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage paginaLogin;

    @BeforeEach
    public void beforeEach(){
        this.paginaLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach(){
        this.paginaLogin.fechar();
    }

    @Test
    public void testeEvetuarLoginComDadosValidos() {

        this.paginaLogin.preencheFormularioDeLogin("fulano", "pass");
        this.paginaLogin.efetuaLogin();

        Assertions.assertFalse(this.paginaLogin.isPaginaLogin());
        Assertions.assertEquals("fulano", this.paginaLogin.getNomeUsuarioLogado());

    }

    @Test
    public void testeNaoDeveriaLogarComDadosInvalidos(){

        this.paginaLogin.preencheFormularioDeLogin("invalido", "pass");
        this.paginaLogin.efetuaLogin();

        Assertions.assertTrue(this.paginaLogin.isPaginaLoginComErro());
        Assertions.assertTrue(this.paginaLogin.contemTexto("Usuário e senha inválidos."));
        Assertions.assertNull(this.paginaLogin.getNomeUsuarioLogado());

    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        this.paginaLogin.navegaParaPaginaDeLances();

        Assertions.assertTrue(this.paginaLogin.isPaginaLogin());
        Assertions.assertFalse(this.paginaLogin.contemTexto("Dados do Leilão"));

    }
}
