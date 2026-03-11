/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jmvm_
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDto {
    private Long id;
    private String cif_empresa;
    private String nombre_empresa;
    private String direccion_empresa;
    private Integer telefono_empresa;
    private String correo_Electronico;
    private boolean esActivo;
    
}
