/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;

/**
 *
 * @author jmvm_
 */


public class EmpresaDto {
    private Long id;
    private String cifEmpresa;
    private String nombre_empresa;
    private String direccion_empresa;
    private Integer telefono_empresa;
    private String correoElectronico;
    private boolean esActivo;

    
    public EmpresaDto(){
        
    }
    public EmpresaDto (Long id,String CifEmpresa,String nombre_empresa,String direccion_empresa,Integer telefono_empresa,String correoElectronico, boolean esActivo){
        
        this.id = id;
        this.cifEmpresa = CifEmpresa;
        this.nombre_empresa= nombre_empresa;
        this.direccion_empresa = direccion_empresa;
        this.telefono_empresa = telefono_empresa;
        this.correoElectronico = correoElectronico;
        this.esActivo = esActivo;
        
        
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCifEmpresa() {
        return cifEmpresa;
    }

    public void setCifEmpresa(String CifEmpresa) {
        this.cifEmpresa = CifEmpresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getDireccion_empresa() {
        return direccion_empresa;
    }

    public void setDireccion_empresa(String direccion_empresa) {
        this.direccion_empresa = direccion_empresa;
    }

    public Integer getTelefono_empresa() {
        return telefono_empresa;
    }

    public void setTelefono_empresa(Integer telefono_empresa) {
        this.telefono_empresa = telefono_empresa;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public boolean isEsActivo() {
        return esActivo;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }
    
    
    
}
