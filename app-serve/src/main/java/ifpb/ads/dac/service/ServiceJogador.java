package ifpb.ads.dac.service;

import ifpb.ads.dac.domain.Jogador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 26/03/2018, 09:54:41
 */
@Stateless
public class ServiceJogador {

    @PersistenceContext
    private EntityManager em;

    public void add(Jogador jogador) {
        em.persist(jogador);
    }

    public List<Jogador> jogadores() {
        return em.createQuery("FROM Jogador j", Jogador.class).getResultList();
    }

    public Jogador jogador(int id) {
        return em.find(Jogador.class, id);
    }

    public Jogador remover(int id) {
        Jogador find = em.find(Jogador.class, id);
        em.remove(find);
        return find;
    }

    public void merge(int id, Jogador jogador) {
        jogador.setId(id);
        em.merge(jogador);
    }

}
