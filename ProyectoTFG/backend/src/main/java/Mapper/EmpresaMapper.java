/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import dto.EmpresaDto;
import entity.Empresa;

/**
 *
 * @author jmvm_
 */
public class EmpresaMapper {
    public static EmpresaDto mapToEmpresaDto(Empresa empresa){
        
        return new EmpresaDto(
                empresa.getId(),
                empresa.getCif_Empresa(),
                empresa.getNombre_empresa(),
                empresa.getDireccion_empresa(),
                empresa.getTelefono_empresa(),
                empresa.getCorreo_electronico(),
                empresa.isActivo()
               
        );
    }
    public static Empresa mapToEmpresa(EmpresaDto empresaDto){
        
        return new Empresa(
                empresaDto.getId(),
                empresaDto.getCif_empresa(),
                empresaDto.getNombre_empresa(),
                empresaDto.getDireccion_empresa(),
                empresaDto.getTelefono_empresa(),
                empresaDto.getCorreo_Electronico(),
                empresaDto.isEsActivo()
        );
    }
    
    
}
