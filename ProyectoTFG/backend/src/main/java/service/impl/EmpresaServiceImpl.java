/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import Mapper.EmpresaMapper;
import dto.EmpresaDto;
import entity.Empresa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.EmpresaRepository;
import service.EmpresaService;

/**
 *
 * @author jmvm_
 */
@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaService{

    private EmpresaRepository empresaRepository;
    
    
    @Override
    public EmpresaDto createEmpresa(EmpresaDto empresaDto) {
        
        Empresa empresa = EmpresaMapper.mapToEmpresa(empresaDto);
        Empresa empresaGuardada = empresaRepository.save(empresa);
        
        return EmpresaMapper.mapToEmpresaDto(empresaGuardada);
        
        
    
}
    
}
