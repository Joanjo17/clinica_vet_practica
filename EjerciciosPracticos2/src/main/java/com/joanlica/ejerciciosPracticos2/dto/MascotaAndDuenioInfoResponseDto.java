/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joanlica.ejerciciosPracticos2.dto;

import lombok.Builder;
import lombok.Value;

/**
 *
 * @author Joan
 */
@Value // Hace la clase inmutable, como un record, crea los constructores necesarios, getters y setters, equals, hashcode y toString.
@Builder // Permite el uso del Patron builder.
public class MascotaAndDuenioInfoResponseDto {
    String nombre_mascota;
    String especie;
    String raza;
    String nombre_duenio;
    String apellido_duenio;
}
