package ifpb.ads.dac.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 26/03/2018, 09:01:19
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Jogador implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String foto; // usaremos um link...

    public Jogador() {
    }

    public Jogador(int id, String nome, String foto) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
    }

    public static Jogador fake() {
        return new Jogador(-1, "fake", "link_fake");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return String.format("https://randomuser.me/api/portraits/men/%d.jpg", id);
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}
