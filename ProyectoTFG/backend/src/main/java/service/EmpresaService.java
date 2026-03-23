/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.EmpresaDto;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmvm_
 */
@Service
public interface EmpresaService {
    
    EmpresaDto createEmpresa(EmpresaDto empresa);
    
}
