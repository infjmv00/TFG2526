/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dto.EmpresaDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.EmpresaService;

/**
 *
 * @author jmvm_
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
    
    // Construccion de REST API para añadir una empresa
    
    private EmpresaService empresaService;
    
    @PostMapping 
    public ResponseEntity<EmpresaDto> createEmpresa(@RequestBody EmpresaDto empresaDto){
        EmpresaDto savedEmpresa = empresaService.createEmpresa(empresaDto);
        return new ResponseEntity(savedEmpresa, HttpStatus.CREATED);
        
        
    }
}
