package com.firatulgay.server.rest;

import com.firatulgay.Domain.Ariza;
import com.firatulgay.Domain.Login;
import com.firatulgay.dao.ArizaDao;
import com.firatulgay.dao.LoginDao;
import com.firatulgay.server.converter.ArizaConverter;
import com.firatulgay.server.converter.LoginConverter;
import com.firatulgay.server.dto.ArizaDto;
import com.firatulgay.server.dto.LoginDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Created by FiratUlgay on 29.12.2019.
 */
@Path("/login")
@Provider
public class LoginRestService {

    @POST
    @Path("/findByAdi")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findByAdi() {
        String adi= "firat";
        String sifre = "1234";
        LoginDao loginDao = new LoginDao();
        Login login = loginDao.findLoginByAdiSifre(adi,sifre);

        LoginConverter loginConverter= new LoginConverter();
        LoginDto loginDto= loginConverter.convertToLoginDto(login);
        return Response.ok().entity(loginDto).build();
    }
}
