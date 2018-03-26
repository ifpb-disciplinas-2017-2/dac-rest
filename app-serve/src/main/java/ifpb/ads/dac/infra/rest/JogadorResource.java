package ifpb.ads.dac.infra.rest;

import ifpb.ads.dac.domain.Jogador;
import ifpb.ads.dac.service.ServiceJogador;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 26/03/2018, 09:02:24
 */
// .../dac-jogador/api/jogador
@Path("jogador")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class JogadorResource {

    @Inject
    private ServiceJogador service;

    @GET
    public Response recuperarTodos() {
        List<Jogador> jogadores = service.jogadores();

        GenericEntity<List<Jogador>> entity
                = new GenericEntity<List<Jogador>>(jogadores) {
        };

        return Response.ok()
                .entity(entity)
                .build();
    }

    // .../dac-jogador/api/jogador/{id}
    @GET
    @Path("{id}")
    public Response recuperarJogador(@PathParam("id") int id) {
        Jogador jogador = service.jogador(id);
        return Response.ok()
                .entity(jogador)
                .build();
    }

    // .../dac-jogador/api/jogador/{id}
    @DELETE
    @Path("{id}")
    public Response removerJogador(@PathParam("id") int id) {
        service.remover(id);
        return Response.ok() // 200
                .build();
    }

    @POST
    public Response adicionarJogador(Jogador jogador) {
        service.add(jogador);
        return Response.ok()
                .entity(jogador)
                .build();
    }

    @PUT
    @Path("{id}")
    public Response atualizarJogador(
            @PathParam("id") int id,
            Jogador jogador) {
        
        service.merge(id,jogador);
        return Response.ok()
                .entity(jogador)
                .build();
    }

}
