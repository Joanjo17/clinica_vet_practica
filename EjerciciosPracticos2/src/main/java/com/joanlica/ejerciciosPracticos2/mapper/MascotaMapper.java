/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joanlica.ejerciciosPracticos2.mapper;

import com.joanlica.ejerciciosPracticos2.dto.MascotaCreateDto;
import com.joanlica.ejerciciosPracticos2.dto.MascotaResponseDto;
import com.joanlica.ejerciciosPracticos2.model.Duenio;
import com.joanlica.ejerciciosPracticos2.model.Mascota;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Joan
 */
public class MascotaMapper {
        
        public static Mascota toEntity(MascotaCreateDto mascota){
            if(mascota == null) return null;
           return new Mascota(null,mascota.nombre(), mascota.especie(),
                                           mascota.raza(), mascota.color(),null);
        }
    
        public static MascotaResponseDto toDto(Mascota mascota){
            if(mascota == null) return null;
            return new MascotaResponseDto(mascota.getId(),mascota.getNombre(), mascota.getEspecie(),
                                            mascota.getRaza(), mascota.getColor(),mascota.getDuenio().getId());
        }

        public static List<MascotaResponseDto> toListDto(List<Mascota> listaMascotas){
            if(listaMascotas == null) return List.of();
            return listaMascotas.stream().map(MascotaMapper::toDto).collect(Collectors.toList());
        }
}
