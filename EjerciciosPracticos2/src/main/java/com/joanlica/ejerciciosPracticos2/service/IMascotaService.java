/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.joanlica.ejerciciosPracticos2.service;

import com.joanlica.ejerciciosPracticos2.dto.MascotaAndDuenioInfoResponseDto;
import com.joanlica.ejerciciosPracticos2.dto.MascotaCreateDto;
import com.joanlica.ejerciciosPracticos2.dto.MascotaResponseDto;
import com.joanlica.ejerciciosPracticos2.model.Mascota;
import java.util.List;

/**
 *
 * @author Joan
 */
public interface IMascotaService {
        
    MascotaResponseDto createMascota(MascotaCreateDto mascota);
    
    List<MascotaResponseDto> getMascotas();
    MascotaResponseDto getMascotaById(Long id);
    Mascota getMascotaEntityById(Long id);
     
    List<MascotaResponseDto> getMascotasByEspecieAndRaza(String especie, String raza);
    MascotaAndDuenioInfoResponseDto getInfoMascotaById(Long id);
    
    MascotaResponseDto updateMascota(Long id, MascotaCreateDto mascotaNueva);
    
    void deleteMascotaById(Long id);
}
