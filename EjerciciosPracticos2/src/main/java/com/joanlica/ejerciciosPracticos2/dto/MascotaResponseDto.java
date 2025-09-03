
package com.joanlica.ejerciciosPracticos2.dto;

/**
 * 
 * @author Joan
 */
public record MascotaResponseDto(
        Long id,
        String nombre,
        String especie,
        String raza,
        String color,

        Long id_duenio
){}
