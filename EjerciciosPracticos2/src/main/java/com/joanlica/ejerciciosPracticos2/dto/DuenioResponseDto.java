/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joanlica.ejerciciosPracticos2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 *     @Column(nullable = false)
        private String dni;
        @Column(nullable = false)
        private String nombre;
        @Column(nullable = false)
        private String apellido;
        
        @Column(name = "num_telefono")
        private String numTelefono;
 * @author Joan
 */
public record DuenioResponseDto(
        Long id,
        String dni,
        String nombre,
        String apellido,
        String numTelefono
        )
{}
