package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

class UsuarioDaoTest {

    private UsuarioDao dao;

    @Test
    void testeDeveriaEncontrarUsuarioCadastrado() {

        EntityManager em = JPAUtil.getEntityManager();
        this.dao = new UsuarioDao(em);

        Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        Usuario encontrado = dao.buscarPorUsername(usuario.getNome());
        Assertions.assertNotNull(encontrado);

    }

    @Test
    void testeNaoDeveriaEncontrarUsuarioNaoCadastrado() {

        EntityManager em = JPAUtil.getEntityManager();
        this.dao = new UsuarioDao(em);

        Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        Assert.assertThrows(NoResultException.class,
                () -> this.dao.buscarPorUsername("Beltrano"));
    }

}