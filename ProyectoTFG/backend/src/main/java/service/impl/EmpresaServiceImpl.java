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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        
        // comprobar que el correo electronico es valido
        
        if (esCorreoElectronico(empresaDto.getCorreoElectronico()) == false){
            throw new ResourceNotFoundException("El correo electronico proporcionado no es válido: " + empresaDto.getCorreoElectronico());
        }
         if (empresaRepository.existsByCorreoElectronico(empresaDto.getCorreoElectronico())) {
            throw new ResourceNotFoundException("Ya existe una empresa registrada con el email: " + empresaDto.getCorreoElectronico());
        }
        
        // 1. Validar el CIF antes de hacer nada más
    if (!isCifValido(empresaDto.getCifEmpresa())) {
        // Lanzamos una excepción (puedes usar ResourceNotFound o una personalizada)
        throw new ResourceNotFoundException("El CIF proporcionado no es válido: " + empresaDto.getCifEmpresa());
    }
    if (empresaRepository.existsByCifEmpresa(empresaDto.getCifEmpresa())) {
            throw new ResourceNotFoundException("Ya existe una empresa registrada con el CIF: " + empresaDto.getCifEmpresa());
        }
        // si es valido guardamos la empresa. 
        Empresa empresa = EmpresaMapper.mapToEmpresa(empresaDto);
        Empresa empresaGuardada = empresaRepository.save(empresa);
        
        return EmpresaMapper.mapToEmpresaDto(empresaGuardada);
        
        
    
}

    @Override
    public EmpresaDto getEmpresaById(Long empresaId) {
      Empresa empresa =  empresaRepository.findById(empresaId).orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con Id : "+empresaId));
        
     return EmpresaMapper.mapToEmpresaDto(empresa);
    }

    @Override
    public List<EmpresaDto> getAllEmpresas() {
       List<Empresa> listaEmpresas = empresaRepository.findAll();
       return listaEmpresas.stream().map((Empresa)->EmpresaMapper.mapToEmpresaDto(Empresa)).collect(Collectors.toList());
       
       
       
        
    }

   @Override
public boolean isCifValido(String cif) {
    // 1. COMPROBACIÓN PREVENTIVA: Si es nulo, fuera inmediatamente.
    if (cif == null) {
        return false;
    }
  
    // 2. EXPRESIÓN REGULAR: Comprobamos formato y longitud (9 caracteres)
    String patronCif = "^[ABCDEFGHJNPQRSUVW][0-9]{7}[A-Z0-9]$";
    Pattern patron = Pattern.compile(patronCif);
    Matcher cumple = patron.matcher(cif);

    // Si no cumple el formato básico (longitud o caracteres), devolvemos false ya.
    if (!cumple.matches()) {
        return false;
    }

    // 3. CÁLCULO MATEMÁTICO: Solo entramos aquí si el Regex confirmó que hay 9 caracteres.
    boolean resultadoFinal = cifValido(cif);
    
    System.out.println("Validación de CIF " + cif + ": " + resultadoFinal);
    return resultadoFinal;
}
    
    
    private static boolean cifValido(String cif) {
        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 1; i <= 7; i++) {
            int digit = Character.getNumericValue(cif.charAt(i));

            if (i % 2 == 0) {
                sumEven += digit;
            } else {
                int tmp = digit * 2;
                sumOdd += tmp / 10 + tmp % 10;
            }
        }

        int controlDigit = (10 - ((sumEven + sumOdd) % 10)) % 10;
        char controlChar = "JABCDEFGHI".charAt(controlDigit);
        char lastChar = cif.charAt(8);

        return lastChar == Character.forDigit(controlDigit, 10)
                || lastChar == controlChar;
    }

    @Override
    public boolean esCorreoElectronico(String correoElectronico) {
        
        String correo = "[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)*@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}";
		Pattern patron = Pattern.compile(correo);
		Matcher cumple =patron.matcher(correoElectronico);
		return cumple.matches();
    
    
    
    }
    
}
