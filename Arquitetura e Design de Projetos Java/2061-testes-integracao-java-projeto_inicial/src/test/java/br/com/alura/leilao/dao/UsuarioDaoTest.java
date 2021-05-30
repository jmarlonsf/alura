package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

class UsuarioDaoTest {

    private UsuarioDao dao;

    @Test
    void testeBuscaDeUsuarioPeloUsername() {

        EntityManager em = JPAUtil.getEntityManager();
        this.dao = new UsuarioDao(em);

        Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        Usuario encontrado = dao.buscarPorUsername(usuario.getNome());
        Assert.assertNotNull(encontrado);

    }

}