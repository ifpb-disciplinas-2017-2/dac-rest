package ifpb.ads.dac.service;

import ifpb.ads.dac.domain.Jogador;
import ifpb.ads.dac.domain.Partida;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 26/03/2018, 09:56:41
 */
@Stateless
public class ServicePartida {

    @PersistenceContext
    private EntityManager em;

    public void add(Partida partida) {
        em.persist(partida);
    }

    public List<Partida> partidas() {
        return em.createQuery("SELECT p FROM Partida p", Partida.class).getResultList();
    }

    public Partida partida(int id) {
        return em.find(Partida.class, id);
    }

    public void remover(int id) {
        Partida find = em.find(Partida.class, id);
        em.remove(find);
    }

    public void merge(int id, Partida partida) {
        partida.setCodigo(id);
        em.merge(partida);
    }

    public Partida novoJogador(int id, int jogadorId) {
        Partida partida = em.find(Partida.class, id);
        Jogador jogador = em.find(Jogador.class, jogadorId);
        partida.novoJogador(jogador);
        Partida merge = em.merge(partida);
        return merge;

    }

}
