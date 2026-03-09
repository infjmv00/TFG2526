/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * https://www.youtube.com/watch?v=KuM6OtuaYRs&list=PLGRDMO4rOGcNLnW1L2vgsExTBg-VPoZHr
 */

package entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author jmvm_
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tblDatos_Empresa")
        
public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="CIF_Empresa")
    private String Cif_Empresa;
     @Column (name="nombre_empresa")
    private String nombre_empresa;
     @Column (name="direccion_empresa")
    private String direccion_empresa;
     @Column (name="Telefonoprov")
    private Integer telefono_empresa;
     @Column (name="e_mail", nullable=false, unique=true )
    private String correo_electronico;
     @Column (name="activoEmpresa")
     private boolean activo;
  

}
