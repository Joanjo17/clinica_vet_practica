/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.joanlica.ejerciciosPracticos2.repository;

import com.joanlica.ejerciciosPracticos2.model.Mascota;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joan
 */
@Repository
public interface IMascotaRepository  extends JpaRepository<Mascota,Long> {
    
        // Busca mascotas donde el nombre contenga 'nombre' Y la especie contenga 'especie'
        List<Mascota> findByEspecieContainsAndRazaContains(String especie, String raza);
    
}
