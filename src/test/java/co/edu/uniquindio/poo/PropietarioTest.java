package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;


public class PropietarioTest {

    
    

    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());
    
        @Test
        public void testDatosCompletosDelPropietario() {
    
            LOG.info("Iniciando prueba de datos completos del propietario");
    
            var propietario = new Propietario("Dei V", "Ul", 27, "7654321", "deiv@gmail.com");
    
            assertEquals("Dei V", propietario.getNombres());
            assertEquals("Ul", propietario.getApellidos());
            assertEquals(27, propietario.getEdad());
            assertEquals("0987654321", propietario.getCelular());
            assertEquals("deiv@gmail.com", propietario.getCorreo());
    
            LOG.info("Finalizando prueba de datos completos del propietario");
        }
    
        @Test
        public void testDatosNulosDelPropietario() {
    
            LOG.info("Iniciando prueba de datos nulos del propietario");
    
            assertThrows(Throwable.class, () -> new Propietario(null, null, 0, null, null));
    
            LOG.info("Finalizando prueba de datos nulos del propietario");
        }
    
        @Test
        public void testDatosVaciosDelPropietario() {
    
            LOG.info("Iniciando prueba de datos vacíos del propietario");
    
            assertThrows(Throwable.class, () -> new Propietario(" ", " ", 0, " ", " "));
    
            LOG.info("Finalizando prueba de datos vacíos del propietario");
        }
    
        @Test
        public void testPropietarioMenorDeEdad() {
    
            LOG.info("Iniciando prueba de propietario menor de edad");
    
            assertThrows(Throwable.class, () -> new Propietario("Dei V", "Ul", -13, "7654321", "deiv@gmail.com"));
    
            LOG.info("Finalizando prueba de propietario menor de edad");
    }
    
    


}
