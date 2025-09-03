/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joanlica.ejerciciosPracticos2.service;

import com.joanlica.ejerciciosPracticos2.dto.MascotaAndDuenioInfoResponseDto;
import com.joanlica.ejerciciosPracticos2.dto.MascotaCreateDto;
import com.joanlica.ejerciciosPracticos2.dto.MascotaResponseDto;
import com.joanlica.ejerciciosPracticos2.exception.ResourceNotFoundException;
import com.joanlica.ejerciciosPracticos2.mapper.MascotaMapper;
import com.joanlica.ejerciciosPracticos2.model.Mascota;
import com.joanlica.ejerciciosPracticos2.repository.IMascotaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joan
 */
@Service
public class MascotaService implements IMascotaService{
        
        private final IMascotaRepository mascotaRepository;
        private final DuenioService duenioService;

        public MascotaService(IMascotaRepository mascotaRepository, DuenioService duenioService) {
            this.mascotaRepository = mascotaRepository;
            this.duenioService = duenioService;
        }



        @Override
        public MascotaResponseDto createMascota(MascotaCreateDto mascota) {
            
            // Convertimos el dto a clase del Modelo y le añadimos el dueño
            Mascota mascotaNueva = MascotaMapper.toEntity(mascota);
            mascotaNueva.setDuenio(duenioService.getDuenioEntityById(mascota.duenio()));
            
            Mascota mascotaGuardada = mascotaRepository.save(mascotaNueva);
            return MascotaMapper.toDto(mascotaGuardada);
        }

        @Override
        public List<MascotaResponseDto> getMascotas() {
            return MascotaMapper.toListDto(mascotaRepository.findAll());
        }
        @Override
        public Mascota getMascotaEntityById(Long id) {
            return mascotaRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada con id: "+id));
        }

        @Override
        public MascotaResponseDto getMascotaById(Long id) {
            return MascotaMapper.toDto(this.getMascotaEntityById(id));
        }
        
        @Override
        public List<MascotaResponseDto> getMascotasByEspecieAndRaza(String especie, String raza) {
            return  MascotaMapper.toListDto(mascotaRepository.findByEspecieContainsAndRazaContains(especie, raza));
        }
        
        @Override
        public MascotaAndDuenioInfoResponseDto getInfoMascotaById(Long id) {
            Mascota mascota = this.getMascotaEntityById(id);
            return MascotaAndDuenioInfoResponseDto.builder()
                    .nombre_mascota(mascota.getNombre())
                    .especie(mascota.getEspecie())
                    .raza(mascota.getRaza())
                    .nombre_duenio(mascota.getDuenio().getNombre())
                    .apellido_duenio(mascota.getDuenio().getApellido())
                    .build();
        }

        @Override
        public MascotaResponseDto updateMascota(Long id, MascotaCreateDto mascotaNueva) {
            Mascota mascota = this.getMascotaEntityById(id);

            mascota.setNombre(mascotaNueva.nombre());
            mascota.setEspecie(mascotaNueva.especie());
            mascota.setRaza(mascotaNueva.raza());
            mascota.setColor(mascotaNueva.color());
            mascota.setDuenio(duenioService.getDuenioEntityById(mascotaNueva.duenio()));

            mascotaRepository.save(mascota);

            return MascotaMapper.toDto(mascota);
        }

        @Override
        @Transactional
        public void deleteMascotaById(Long id) {
            // Buscamos la entidad a eliminar si es que existe, y despues borramos.
            Mascota mascota = this.getMascotaEntityById(id);
            // 1. Break the bidirectional link from the Duenio side
            if (mascota.getDuenio() != null) {
                mascota.getDuenio().setMascota(null);
            }

            mascotaRepository.delete(mascota);
        }

}
