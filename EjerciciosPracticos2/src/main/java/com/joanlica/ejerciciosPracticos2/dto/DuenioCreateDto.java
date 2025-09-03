/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joanlica.ejerciciosPracticos2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * @author Joan
 */
public record DuenioCreateDto(
        @NotBlank(message="Dni inválido.")
        @Pattern(regexp = "^[0-9]{8}[A-Z]$", message = "El DNI debe tener 8 dígitos seguidos de una letra mayúscula.")       
        String dni,
        @NotBlank(message="Nombre inválido.")
        String nombre,
        @NotBlank(message="Apellido inválido.")
        String apellido,
        @NotBlank(message="Número de telefono inválido.")
        String numTelefono
        )
{}
