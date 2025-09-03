
package com.joanlica.ejerciciosPracticos2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 *         @Column(nullable = false)
        private String nombre;
        @Column(nullable = false)
         private String especie;
         @Column(nullable = false)
         private String raza;
         @Column(nullable = false)
         private String color;
         
         @OneToOne(optional = false)
         @JoinColumn(name= "id_duenio")
         private Duenio duenio;
 * @author Joan
 */
public record MascotaCreateDto(
        @NotBlank(message="Nombre inválido")
        String nombre,
        @NotBlank(message="Especie inválida")
        String especie,
        @NotBlank(message="Raza inválida")
        String raza,
        @NotBlank(message="Color inválido")
        String color,
        
        @NotNull(message="Dueño no debe ser nulo")
        @Positive(message="Dueño inválido")
        Long duenio
){}
