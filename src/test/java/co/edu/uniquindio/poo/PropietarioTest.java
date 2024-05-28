package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class PropietarioTest {

    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());
    
        @Test
        public void testDatosCompletos() {
    
            LOG.info("Iniciando prueba de datos completos del propietario");
    
            var propietario = new Propietario("Dei V", "Ul", 27, "7654321", "deiv@gmail.com");
    
            assertEquals("Dei V", propietario.getNombre());
            assertEquals("Ul", propietario.getApellido());
            assertEquals(27, propietario.getEdad());
            assertEquals("7654321", propietario.getCelular());
            assertEquals("deiv@gmail.com", propietario.getCorreo());
    
            LOG.info("Finalizando prueba de datos completos del propietario");
        }
    
        @Test
        public void datosNulos() {
    
            LOG.info("Iniciando prueba de datos nulos del propietario");
    
            assertThrows(Throwable.class, () -> new Propietario(null, null, 0, null, null));
    
            LOG.info("Finalizando prueba de datos nulos del propietario");
        }
    
        @Test
        public void datosVacios() {
    
            LOG.info("Iniciando prueba de datos vacíos del propietario");
    
            assertThrows(Throwable.class, () -> new Propietario(" ", " ", 0, " ", " "));
    
            LOG.info("Finalizando prueba de datos vacíos del propietario");
        }
    
        @Test
        public void propietarioMenorDeEdad() {
    
            LOG.info("Iniciando prueba de propietario menor de edad");
    
            assertThrows(Throwable.class, () -> new Propietario("Dei V", "Ul", 17, "7654321", "deiv@gmail.com"));
    
            LOG.info("Finalizando prueba de propietario menor de edad");
    }
    
    

    @Test
    public void datosCompletosDelPropietario() {

        LOG.info("Iniciando prueba de datos completos del propietario");

        var propietario = new Propietario("Dei V", "Ul", 27, "7654321", "deiv@gmail.com");

        assertEquals("Dei V", propietario.getNombre());
        assertEquals("Ul", propietario.getApellido());
        assertEquals(27, propietario.getEdad());
        assertEquals("7654321", propietario.getCelular());
        assertEquals("deiv@gmail.com", propietario.getCorreo());

        LOG.info("Finalizando prueba de datos completos del propietario");
    }

    @Test
    public void datosNulosDelPropietario() {

        LOG.info("Iniciando prueba de datos nulos del propietario");

        assertThrows(Throwable.class, () -> new Propietario(null, null, 0, null, null));

        LOG.info("Finalizando prueba de datos nulos del propietario");
    }

    @Test
    public void datosVaciosDelPropietario() {

        LOG.info("Iniciando prueba de datos vacíos del propietario");

        assertThrows(Throwable.class, () -> new Propietario(" ", " ", 0, " ", " "));

        LOG.info("Finalizando prueba de datos vacíos del propietario");
    }

   
    

}
