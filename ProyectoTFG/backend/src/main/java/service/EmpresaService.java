/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.EmpresaDto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmvm_
 */
@Service
public interface EmpresaService {
    
    EmpresaDto createEmpresa(EmpresaDto empresa);
    
    EmpresaDto getEmpresaById(Long empresaId);
    
    List <EmpresaDto> getAllEmpresas();
    
}
