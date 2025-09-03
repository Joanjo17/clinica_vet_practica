/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joanlica.ejerciciosPracticos2.service;

import com.joanlica.ejerciciosPracticos2.dto.DuenioCreateDto;
import com.joanlica.ejerciciosPracticos2.dto.DuenioResponseDto;
import com.joanlica.ejerciciosPracticos2.exception.ResourceNotFoundException;
import com.joanlica.ejerciciosPracticos2.mapper.DuenioMapper;
import com.joanlica.ejerciciosPracticos2.model.Duenio;
import com.joanlica.ejerciciosPracticos2.repository.IDuenioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joan
 */
@Service
public class DuenioService implements IDuenioService{
        private final IDuenioRepository duenioRepository;

        public DuenioService(IDuenioRepository duenioRepository) {
            this.duenioRepository = duenioRepository;
        }

        @Override
        public DuenioResponseDto createDuenio(DuenioCreateDto duenio) {
            Duenio duenioNuevo = duenioRepository.save(DuenioMapper.toEntity(duenio));
            return DuenioMapper.toDto(duenioNuevo);
        }

        @Override
        public List<DuenioResponseDto> getDuenios() {
            return DuenioMapper.toListDto(duenioRepository.findAll());
        }
        @Override
        public Duenio getDuenioEntityById(Long id) {
            return duenioRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Dueño no encontrado con la id: "+id));
        }

        @Override
        public DuenioResponseDto getDuenioById(Long id) {
            return DuenioMapper.toDto(this.getDuenioEntityById(id));
        }

        @Override
        public DuenioResponseDto updateDuenio(Long id, DuenioCreateDto duenioNuevo) {
             Duenio duenio = this.getDuenioEntityById(id);

            duenio.setDni(duenioNuevo.dni());
            duenio.setNombre(duenioNuevo.nombre());
            duenio.setApellido(duenioNuevo.apellido());
            duenio.setNumTelefono(duenioNuevo.numTelefono());

            duenioRepository.save(duenio);

            return DuenioMapper.toDto(duenio);
        }

        @Override
        @Transactional
        public void deleteDuenioById(Long id) {
            /* Antes de eliminar algo comprobamos si el dueño existe, en ese caso se elimina,
                si no, se informa que no fue encontrado.
            */
            Duenio duenio =  this.getDuenioEntityById(id);
            
            duenioRepository.delete(duenio);
        }

        
        
}
