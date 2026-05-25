import React, { useState } from 'react';
import { postEmpresa } from './services/empresaService';

function AltaEmpresa() {
  const [formData, setFormData] = useState({
    cifEmpresa: '',
    nombre_empresa: '',
    direccion_empresa: '',
    telefono_empresa: '',
    correoElectronico: '',
    esActivo: true 
  });

  // Estado para controlar el bloqueo del botón de envío
  const [isSubmitting, setIsSubmitting] = useState(false);

  const handleChange = (event) => {
    const { name, value, type, checked } = event.target;
    
    // Si el input es un checkbox, extraemos 'checked' en lugar de 'value'
    setFormData({
      ...formData,
      [name]: type === 'checkbox' ? checked : value
    });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    setIsSubmitting(true); // Bloqueamos el formulario

    const datosParaEnviar = {
      ...formData,
      telefono_empresa: formData.telefono_empresa === "" ? null : parseInt(formData.telefono_empresa, 10)
    };

    try {
      console.log("Enviando datos al backend...", datosParaEnviar);
      
      const respuesta = await postEmpresa(datosParaEnviar);
      
      console.log("Respuesta del servidor:", respuesta);
      alert("¡Empresa registrada correctamente!");
      
      // Reiniciamos el formulario a su estado original
      setFormData({
        cifEmpresa: '',
        nombre_empresa: '',
        direccion_empresa: '',
        telefono_empresa: '',
        correoElectronico: '',
        esActivo: true
      });

    } catch (error) {
      console.error("Error al invocar el servicio:", error);
      alert(`No se pudo registrar la empresa: ${error.message}`);
    } finally {
      setIsSubmitting(false); // Desbloqueamos el formulario ocurra o no un error
    }
  };

  return (
    <section className="AltaEmpresa">
      <header>
        <h2>Nuevo Registro de Empresa</h2>
      </header>

      <form onSubmit={handleSubmit}>
        <fieldset>
          <legend>Información Legal</legend>
          
          <div className="form-group">
            <label htmlFor="nombre_empresa">Nombre Comercial:</label>
            <input 
              id="nombre_empresa" 
              name="nombre_empresa" 
              type="text" 
              value={formData.nombre_empresa} 
              onChange={handleChange} 
              required 
            />
          </div>

          <div className="form-group">
            <label htmlFor="cifEmpresa">CIF:</label>
            <input 
              id="cifEmpresa" 
              name="cifEmpresa" 
              type="text" 
              value={formData.cifEmpresa} 
              onChange={handleChange} 
              required 
            />
          </div>
        </fieldset>

        <fieldset>
          <legend>Contacto y Localización</legend>

          <div className="form-group">
            <label htmlFor="direccion_empresa">Dirección Postal:</label>
            <input 
              id="direccion_empresa" 
              name="direccion_empresa" 
              type="text" 
              value={formData.direccion_empresa} 
              onChange={handleChange} 
            />
          </div>

          <div className="form-group">
            <label htmlFor="telefono_empresa">Teléfono:</label>
            <input 
              id="telefono_empresa" 
              name="telefono_empresa" 
              type="number" 
              value={formData.telefono_empresa} 
              onChange={handleChange} 
            />
          </div>

          <div className="form-group">
            <label htmlFor="correoElectronico">Email Corporativo:</label>
            <input 
              id="correoElectronico" 
              name="correoElectronico" 
              type="email" 
              value={formData.correoElectronico} 
              onChange={handleChange} 
              required 
            />
          </div>

          {/* Campo esActivo opcional integrado en el formulario */}
          <div className="form-group checkbox-group">
            <label htmlFor="esActivo">
              <input 
                id="esActivo" 
                name="esActivo" 
                type="checkbox" 
                checked={formData.esActivo} 
                onChange={handleChange} 
              />
              Empresa Activa de Alta
            </label>
          </div>
        </fieldset>

        {/* Deshabilitamos el botón para evitar doble submit */}
        <button type="submit" disabled={isSubmitting}>
          {isSubmitting ? 'Guardando...' : 'Guardar en Sistema'}
        </button>
      </form>
    </section>
  );
}

export default AltaEmpresa;