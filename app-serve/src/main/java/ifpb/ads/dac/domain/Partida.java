package ifpb.ads.dac.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 26/03/2018, 10:49:24
 */
@Entity
public class Partida implements Serializable {

    @Id
    @GeneratedValue
    private int codigo;
    private String esporte;
    private LocalDate dataCriacao = LocalDate.now();
    private Status status = Status.CRIADA;
    @ManyToMany
    private List<Jogador> jogadores = new ArrayList<>();

    public Partida() {}

    public Partida(int codigo, String esporte) {
        this(codigo, esporte, LocalDate.now(), Status.CRIADA);
    }

    public Partida(int codigo, String esporte, LocalDate dataCriacao, Status status) {
        this.codigo = codigo;
        this.esporte = esporte;
        this.dataCriacao = dataCriacao;
        this.status = status;
    }

    public void novoJogador(Jogador jogador) {
        this.jogadores.add(jogador);
    }

    public void removerJogador(Jogador jogador) {
        this.jogadores.remove(jogador);
    }

    public Jogador jogadorComId(int id) {
        return this.jogadores.stream()
                .filter(j -> j.getId() == id)
                .findFirst()
                .orElse(Jogador.fake());
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEsporte() {
        return esporte;
    }

    public void setEsporte(String esporte) {
        this.esporte = esporte;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codigo;
        hash = 59 * hash + Objects.hashCode(this.esporte);
        hash = 59 * hash + Objects.hashCode(this.dataCriacao);
        hash = 59 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partida other = (Partida) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.esporte, other.esporte)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

}
