package com.firatulgay.server.rest;

import com.firatulgay.Domain.Ariza;
import com.firatulgay.dao.ArizaDao;
import com.firatulgay.server.converter.ArizaConverter;
import com.firatulgay.server.dto.ArizaDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Path("/ariza")
@Provider
public class ArizaRestService {

    @POST
    @Path("/findAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {

        ArizaDao arizaDao = new ArizaDao();
        List<Ariza> arizaList = arizaDao.findAllAriza();

        ArizaConverter arizaConverter = new ArizaConverter();
        List<ArizaDto> arizaDtoList = arizaConverter.convertArizaDtoList(arizaList);
        return Response.ok().entity(arizaDtoList).build();
    }

    @GET
    @Path("/findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        ArizaDao arizaDao = new ArizaDao();
        Ariza ariza = arizaDao.findAllArizaById(id);

        ArizaConverter arizaConverter = new ArizaConverter();
        ArizaDto arizaDto = arizaConverter.convertToArizaDto(ariza);
        return Response.ok().entity(arizaDto).build();
    }

    @POST
    @Path("/findByIdPost")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByIdPost(@FormParam("id") Long id) {
        ArizaDao ArizaDao = new ArizaDao();
        Ariza ariza = ArizaDao.findAllArizaById(id);

        ArizaConverter arizaConverter = new ArizaConverter();
        ArizaDto arizaDto = arizaConverter.convertToArizaDto(ariza);
        return Response.ok().entity(arizaDto).build();
    }

    @POST
    @Path("/saveAriza")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveAriza(ArizaDto arizaDto) {

        ArizaConverter arizaConverter = new ArizaConverter();
        Ariza ariza = arizaConverter.convertToAriza(arizaDto);

        ArizaDao arizaDao = new ArizaDao();
        ariza = arizaDao.saveAriza(ariza);

        arizaDto = arizaConverter.convertToArizaDto(ariza);
        return Response.ok().entity(arizaDto).build();


    }

}