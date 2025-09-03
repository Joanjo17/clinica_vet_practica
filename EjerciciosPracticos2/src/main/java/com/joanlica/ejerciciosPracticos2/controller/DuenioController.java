
package com.joanlica.ejerciciosPracticos2.controller;

import com.joanlica.ejerciciosPracticos2.dto.DuenioCreateDto;
import com.joanlica.ejerciciosPracticos2.dto.DuenioResponseDto;
import com.joanlica.ejerciciosPracticos2.service.IDuenioService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Joan
 */
@RestController
@RequestMapping("/duenios")
public class DuenioController {
    
        private final IDuenioService duenioService;

        public DuenioController(IDuenioService duenioService) {
            this.duenioService = duenioService;
        }
        
        /*
        2. crud dueños
        */
        
        @PostMapping("")
        public ResponseEntity<DuenioResponseDto> crearDuenio(@Valid @RequestBody DuenioCreateDto duenio){
            DuenioResponseDto duenioNuevo = duenioService.createDuenio(duenio);
           URI location = URI.create("/duenios/" + duenioNuevo.id());
            return ResponseEntity.created(location).body(duenioNuevo);
        }
        
        @GetMapping("")
        public ResponseEntity<List<DuenioResponseDto>> obtenerDuenios(){
            return ResponseEntity.ok(duenioService.getDuenios());
        }
         @GetMapping("/{id}")
        public ResponseEntity<DuenioResponseDto> obtenerDuenioPorId(@PathVariable Long id){
            return ResponseEntity.ok(duenioService.getDuenioById(id));
        }
        
        @PutMapping("/{id}")
        public ResponseEntity<DuenioResponseDto> actualizarDuenio(@PathVariable Long id, @Valid @RequestBody DuenioCreateDto duenio){
            return ResponseEntity.ok(duenioService.updateDuenio( id, duenio));
        }
        
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminarDuenio(@PathVariable Long id){
            duenioService.deleteDuenioById( id);
            return ResponseEntity.noContent().build();
        }
    
}
