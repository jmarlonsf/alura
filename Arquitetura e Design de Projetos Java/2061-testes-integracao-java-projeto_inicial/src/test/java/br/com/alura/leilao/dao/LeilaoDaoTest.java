package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
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
        Usuario usuario = criarUsuario();
        Leilao leilao = new Leilao("Mochila", new BigDecimal("70"), LocalDate.now(), usuario);

        leilao = this.dao.salvar(leilao);

        Leilao salvo = this.dao.buscarPorId(leilao.getId());

        Assertions.assertNotNull(salvo);
    }

    @Test
    void deveriaAtualizarUmLeilao(){
        Usuario usuario = criarUsuario();
        Leilao leilao = new Leilao("Mochila", new BigDecimal("70"), LocalDate.now(), usuario);

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

    private Usuario criarUsuario(){

        Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
        this.em.persist(usuario);
        return usuario;
    }

}