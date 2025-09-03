
package com.joanlica.ejerciciosPracticos2.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Duenio {
    
        @Id
        @GeneratedValue(strategy =  GenerationType.SEQUENCE)
        private Long id;
        
        @Column(nullable = false)
        private String dni;
        @Column(nullable = false)
        private String nombre;
        @Column(nullable = false)
        private String apellido;
        
        @Column(name = "num_telefono")
        private String numTelefono;
        
        @OneToOne(mappedBy = "duenio", cascade = CascadeType.ALL, orphanRemoval = true)
        private Mascota mascota;
}
