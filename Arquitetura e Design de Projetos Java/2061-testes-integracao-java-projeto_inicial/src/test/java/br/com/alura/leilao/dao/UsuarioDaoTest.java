package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.UsuarioBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

class UsuarioDaoTest {

    private UsuarioDao dao;
    private EntityManager em;

    @BeforeEach
    void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new UsuarioDao(em);
        this.em.getTransaction().begin();
    }

    @AfterEach
    void afterEach() {
        this.em.getTransaction().rollback();
    }

    @Test
    void testeDeveriaEncontrarUsuarioCadastrado() {

        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678").criar();
        em.persist(usuario);

        Usuario encontrado = dao.buscarPorUsername(usuario.getNome());
        Assertions.assertNotNull(encontrado);

    }

    @Test
    void testeNaoDeveriaEncontrarUsuarioNaoCadastrado() {

        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678").criar();
        em.persist(usuario);

        Assert.assertThrows(NoResultException.class,
                () -> this.dao.buscarPorUsername("Beltrano"));
    }

    @Test
    void testeDeveriaRemoverUmUsuario() {
        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678").criar();
        dao.deletar(usuario);

        Assert.assertThrows(NoResultException.class,
                () -> this.dao.buscarPorUsername(usuario.getNome()));
    }

}