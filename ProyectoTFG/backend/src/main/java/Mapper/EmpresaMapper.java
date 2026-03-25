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
                empresa.getCifEmpresa(),
                empresa.getNombre_empresa(),
                empresa.getDireccion_empresa(),
                empresa.getTelefono_empresa(),
                empresa.getCorreoElectronico(),
                empresa.isActivo()
               
        );
    }
    public static Empresa mapToEmpresa(EmpresaDto empresaDto){
        
        return new Empresa(
                
                //empresaDto.getId(),
                empresaDto.getCifEmpresa(),
                empresaDto.getNombre_empresa(),
                empresaDto.getDireccion_empresa(),
                empresaDto.getTelefono_empresa(),
                empresaDto.getCorreoElectronico(),
                empresaDto.isEsActivo()
        );
    }
    
    
}
