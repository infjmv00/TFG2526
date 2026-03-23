/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * https://www.youtube.com/watch?v=KuM6OtuaYRs&list=PLGRDMO4rOGcNLnW1L2vgsExTBg-VPoZHr
 */

package entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Data;


/**
 *
 * @author jmvm_
 */


@Entity
@Table(name ="tblDatos_Empresa")
        
public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="CIF_Empresa")
    private String CifEmpresa;
     @Column (name="nombre_empresa")
    private String nombre_empresa;
     @Column (name="direccion_empresa")
    private String direccion_empresa;
     @Column (name="Telefonoprov")
    private Integer telefono_empresa;
     @Column (name="e_mail", nullable=false, unique=true )
    private String correoElectronico;
     @Column (name="activoEmpresa")
     private boolean activo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCifEmpresa() {
        return CifEmpresa;
    }

    public void setCifEmpresa(String CifEmpresa) {
        this.CifEmpresa = CifEmpresa;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
  
    public Empresa(){
        
    }
    public Empresa (String CifEmpresa,String nombre_empresa,String direccion_empresa,Integer telefono_empresa,String correoElectronico,boolean esAactivo){
        
        this.CifEmpresa = CifEmpresa;
        this.nombre_empresa= nombre_empresa;
        this.direccion_empresa = direccion_empresa;
        this.telefono_empresa = telefono_empresa;
        this.correoElectronico = correoElectronico;
        this.activo = esAactivo;
        
        
        
    }
    

}
