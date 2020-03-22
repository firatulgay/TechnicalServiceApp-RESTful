package com.firatulgay.server.converter;

import com.firatulgay.Domain.Ariza;
import com.firatulgay.Domain.Login;
import com.firatulgay.server.dto.ArizaDto;
import com.firatulgay.server.dto.LoginDto;

/**
 * Created by FiratUlgay on 29.12.2019.
 */
public class LoginConverter {

    public LoginDto convertToLoginDto(Login login) {

        LoginDto loginDto = new LoginDto();
        loginDto.setId(login.getId());
        loginDto.setAdi(login.getAdi());
        loginDto.setSifre(login.getSifre());

        return loginDto;
    }
}
