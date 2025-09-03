/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joanlica.ejerciciosPracticos2.mapper;

import com.joanlica.ejerciciosPracticos2.dto.DuenioCreateDto;
import com.joanlica.ejerciciosPracticos2.dto.DuenioResponseDto;
import com.joanlica.ejerciciosPracticos2.model.Duenio;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Joan
 */
public class DuenioMapper {
    
    public static Duenio toEntity(DuenioCreateDto duenio){
        if(duenio == null) return null;
        return new Duenio(null,duenio.dni(),
                duenio.nombre(),duenio.apellido(),
                duenio.numTelefono(),null);
    }
    
    public static DuenioResponseDto toDto(Duenio duenio){
        if(duenio == null) return null;
        return new DuenioResponseDto(duenio.getId(),duenio.getDni(),
                                                            duenio.getNombre(),duenio.getApellido(),
                                                            duenio.getNumTelefono());
    }
    
    public static List<DuenioResponseDto> toListDto(List<Duenio> listaDuenios){
        if(listaDuenios == null) return List.of();
        return listaDuenios.stream().map(DuenioMapper::toDto).collect(Collectors.toList());
    }
    
}
