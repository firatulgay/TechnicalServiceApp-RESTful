package com.firatulgay.server.converter;

import com.firatulgay.Domain.Ariza;
import com.firatulgay.Domain.Login;
import com.firatulgay.server.dto.ArizaDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FiratUlgay on 26.12.2019.
 */
public class ArizaConverter {

    public Ariza convertToAriza(ArizaDto arizaDto) {

        Ariza ariza = new Ariza();
        ariza.setId(arizaDto.getId());
        ariza.setAdi(arizaDto.getAdi());
        ariza.setContent(arizaDto.getContent());
        ariza.setDate(arizaDto.getDate());
        ariza.setEnumState(arizaDto.getEnumState());
        ariza.setDescription(arizaDto.getDescription());

        return ariza;
    }
    public ArizaDto convertToArizaDto(Ariza ariza) {

        ArizaDto arizaDto = new ArizaDto();
        arizaDto.setId(ariza.getId());
        arizaDto.setAdi(ariza.getAdi());
        arizaDto.setContent(ariza.getContent());
        arizaDto.setDate(ariza.getDate());
        arizaDto.setEnumState(ariza.getEnumState());
        arizaDto.setDescription(ariza.getDescription());

        return arizaDto;
    }
    public List<ArizaDto> convertArizaDtoList(List<Ariza> arizaList) {

        List<ArizaDto> arizaDtoList = new ArrayList<>();
        for (Ariza ariza : arizaList) {
            ArizaDto arizaDto = convertToArizaDto(ariza);
            arizaDtoList.add(arizaDto);
        }
        return arizaDtoList;
    }
}
