
package com.joanlica.ejerciciosPracticos2.controller;

import com.joanlica.ejerciciosPracticos2.dto.MascotaAndDuenioInfoResponseDto;
import com.joanlica.ejerciciosPracticos2.dto.MascotaCreateDto;
import com.joanlica.ejerciciosPracticos2.dto.MascotaResponseDto;
import com.joanlica.ejerciciosPracticos2.service.IMascotaService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Joan
 */
@RestController
@RequestMapping("/mascotas")
public class MascotaController {
    
        private final IMascotaService mascotaService;

        public MascotaController(IMascotaService mascotaService) {
            this.mascotaService = mascotaService;
        }
        
        /*
        1. crud mascotas
        3. listado mascotas de especie "perro" y raza "caniche"
        4. Info Mascota y dueño:{
            nombre_macota,
            especie,
            raza,
            nombre_duenio,
            apellido_duenio
        }
        */
        
        @PostMapping("")
        public ResponseEntity<MascotaResponseDto> crearMascota(@Valid @RequestBody MascotaCreateDto mascota){
            MascotaResponseDto mascotaNueva = mascotaService.createMascota(mascota);
           URI location = URI.create("/mascotas/" + mascotaNueva.id());
            return ResponseEntity.created(location).body(mascotaNueva);
        }
        
        @GetMapping("")
        public ResponseEntity<List<MascotaResponseDto>> obtenerMascotas(
            @RequestParam(required = false) String especie,
            @RequestParam(required = false) String raza) {

            if (especie != null && raza != null) {
                return ResponseEntity.ok(mascotaService.getMascotasByEspecieAndRaza(especie, raza));
            } else {
                return ResponseEntity.ok(mascotaService.getMascotas());
            }
        }
        
         @GetMapping("/{id}")
        public ResponseEntity<MascotaResponseDto> obtenerMascotaPorId(@PathVariable Long id){
            return ResponseEntity.ok(mascotaService.getMascotaById(id));
        }
        
        @PutMapping("/{id}")
        public ResponseEntity<MascotaResponseDto> actualizarMascota(@PathVariable Long id, @Valid @RequestBody MascotaCreateDto mascota){
            return ResponseEntity.ok(mascotaService.updateMascota( id, mascota));
        }
        
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminarMascota(@PathVariable Long id){
            mascotaService.deleteMascotaById( id);
            return ResponseEntity.noContent().build();
        }
        
        /* Ahora esta dentro del GetMapping de obtener todas las mascotas.
            @GetMapping("/filtrar")
            public ResponseEntity<List<MascotaResponseDto>> obtenerMascotasPorEspecieYRaza(@RequestParam String especie, @RequestParam String raza){
                return ResponseEntity.ok(mascotaService.getMascotasByEspecieAndRaza(especie, raza));
            }
        */
        
        @GetMapping("/{id}/info")
        public ResponseEntity<MascotaAndDuenioInfoResponseDto> obtenerInfoMascotaPorId(@PathVariable Long id){
            return ResponseEntity.ok(mascotaService.getInfoMascotaById(id));
        } 
    
}
