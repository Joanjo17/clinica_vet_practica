/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.joanlica.ejerciciosPracticos2.service;

import com.joanlica.ejerciciosPracticos2.dto.DuenioCreateDto;
import com.joanlica.ejerciciosPracticos2.dto.DuenioResponseDto;
import com.joanlica.ejerciciosPracticos2.model.Duenio;
import java.util.List;

/**
 *
 * @author Joan
 */
public interface IDuenioService {
    DuenioResponseDto createDuenio(DuenioCreateDto duenio);
    
    List<DuenioResponseDto> getDuenios();
    DuenioResponseDto getDuenioById(Long id);
    Duenio getDuenioEntityById(Long id);
    
    DuenioResponseDto updateDuenio(Long id, DuenioCreateDto duenioNuevo);
    
    void deleteDuenioById(Long id);
}
