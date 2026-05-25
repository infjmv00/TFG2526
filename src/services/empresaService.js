// Definimos la URL base de tu backend (Spring Boot por defecto suele usar el puerto 8080)
// Modifica esta URL si tu backend está corriendo en otro puerto o dominio.
const API_BASE_URL = 'http://localhost:8080/api/empresas'; 

/**
 * Envía los datos de una nueva empresa al servidor mediante una petición POST.
 * * @param {Object} empresaData - Objeto con los datos del formulario (EmpresaDto)
 * @returns {Promise<Object>} - Promesa con la respuesta del servidor en formato JSON
 */
export const postEmpresa = async (empresaData) => {
  try {
    const response = await fetch(API_BASE_URL, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        // Si usas tokens de autenticación como JWT, los añadirías aquí:
        // 'Authorization': `Bearer ${token}`
      },
      body: JSON.stringify(empresaData),
    });

    // Validamos si la respuesta del servidor es correcta (status en el rango 200-299)
    if (!response.ok) {
      // Intentamos obtener el mensaje de error del backend si existe
      const errorResponse = await response.json().catch(() => ({}));
      throw new Error(errorResponse.message || `Error en la petición: ${response.status}`);
    }

    // Si el backend devuelve un No Content (204), evitamos parsear un JSON vacío
    if (response.status === 204) {
      return { success: true };
    }

    return await response.json();
  } catch (error) {
    console.error("Error en postEmpresa service:", error);
    throw error; // Re-lanzamos el error para que lo capture el catch del componente
  }
};