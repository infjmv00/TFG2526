/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import Mapper.EmpresaMapper;
import dto.EmpresaDto;
import entity.Empresa;
import exception.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
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

    @Override
    public EmpresaDto getEmpresaById(Long empresaId) {
      Empresa empresa =  empresaRepository.findById(empresaId).orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con Id :"+empresaId));
        
     return EmpresaMapper.mapToEmpresaDto(empresa);
    }

    @Override
    public List<EmpresaDto> getAllEmpresas() {
       List<Empresa> listaEmpresas = empresaRepository.findAll();
       return listaEmpresas.stream().map((Empresa)->EmpresaMapper.mapToEmpresaDto(Empresa)).collect(Collectors.toList());
       
       
       
        
    }
    
    
    
}
