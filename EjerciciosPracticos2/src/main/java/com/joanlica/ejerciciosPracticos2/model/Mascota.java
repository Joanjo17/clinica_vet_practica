
package com.joanlica.ejerciciosPracticos2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Joan
 */
@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Mascota {
    
        @Id
        @GeneratedValue(strategy =  GenerationType.SEQUENCE)
        private Long id;
        
        @Column(nullable = false)
        private String nombre;
        
        @Column(nullable = false)
         private String especie;
        
        @Column(nullable = false)
         private String raza;
        
        @Column(nullable = false)
         private String color;
         
         @OneToOne
         @JoinColumn(name= "id_duenio", nullable = true)
         private Duenio duenio;
}
