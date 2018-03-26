package ifpb.ads.dac.infra.rest;

import ifpb.ads.dac.domain.Jogador;
import ifpb.ads.dac.domain.Partida;
import ifpb.ads.dac.service.ServiceJogador;
import ifpb.ads.dac.service.ServicePartida;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 26/03/2018, 09:02:24
 */
// .../dac-jogador/api/jogador
@Path("partida")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class PartidaResource {

    @Inject
    private ServicePartida service;

    @GET
    public Response recuperarTodos() {
        List<Partida> partidas = service.partidas();
        GenericEntity<List<Partida>> entity = new GenericEntity<List<Partida>>(partidas) {
        };
        return Response.ok()
                .entity(entity)
                .build();
    }

    @GET
    @Path("{id}")
    public Response recuperarPartida(@PathParam("id") int id) {
        Partida partida = service.partida(id);
        return Response.ok()
                .entity(partida)
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response removerPartida(@PathParam("id") int id) {
        service.remover(id);
        return Response.ok() // 200
                .build();
    }

    @POST
    public Response adicionarPartida(Partida partida) {
        service.add(partida);
        return Response.ok()
                .entity(partida)
                .build();
    }

    @PUT
    @Path("{id}")
    public Response atualizarPartida(@PathParam("id") int id, Partida partida) {
        service.merge(id, partida);
        return Response.ok()
                .entity(partida)
                .build();
    }

    @GET
    @Path("{id}/jogador")
    public Response listarPorJogador(@PathParam("id") int id) {
        Partida partida = this.service.partida(id);
        GenericEntity<List<Jogador>> retorno = new GenericEntity<List<Jogador>>(partida.getJogadores()) {
        };
        return Response.ok()
                .entity(retorno)
                .build();
    }

    @PUT
    @Path("{id}/jogador/{jogadorId}")
    public Response listarPorJogador(@PathParam("id") int id,
            @PathParam("jogadorId") int jogadorId) {

        Partida partida = this.service.novoJogador(id, jogadorId);

        return Response.ok()
                .entity(partida)
                .build();
    }
}
