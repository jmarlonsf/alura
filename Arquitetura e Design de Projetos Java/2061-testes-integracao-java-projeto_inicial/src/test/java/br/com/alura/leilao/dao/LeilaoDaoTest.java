package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.LeilaoBuilder;
import br.com.alura.leilao.util.builder.UsuarioBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

class LeilaoDaoTest {

    private LeilaoDao dao;
    private EntityManager em;

    @BeforeEach
    void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new LeilaoDao(em);
        this.em.getTransaction().begin();
    }

    @AfterEach
    void afterEach() {
        this.em.getTransaction().rollback();
    }

    @Test
    void deveriaCadastrarUmLeilao(){
        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678").criar();
        this.em.persist(usuario);

        Leilao leilao = new LeilaoBuilder()
                .comNome("Mochila")
                .comValorInicial("500")
                .comData(LocalDate.now())
                .comUsuario(usuario)
                .criar();

        leilao = this.dao.salvar(leilao);

        Leilao salvo = this.dao.buscarPorId(leilao.getId());

        Assertions.assertNotNull(salvo);
    }

    @Test
    void deveriaAtualizarUmLeilao(){
        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678").criar();
        this.em.persist(usuario);

        Leilao leilao = new LeilaoBuilder()
                .comNome("Mochila")
                .comValorInicial("500")
                .comData(LocalDate.now())
                .comUsuario(usuario)
                .criar();

        //cria
        leilao = this.dao.salvar(leilao);

        leilao.setNome("Celular");
        leilao.setValorInicial(new BigDecimal("400"));

        //atualiza
        leilao = this.dao.salvar(leilao);

        Leilao salvo = this.dao.buscarPorId(leilao.getId());

        Assertions.assertEquals(leilao.getNome(), salvo.getNome());
        Assertions.assertEquals(leilao.getValorInicial(), salvo.getValorInicial());
    }

}