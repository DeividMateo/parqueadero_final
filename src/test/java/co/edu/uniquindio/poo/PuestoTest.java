package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class PuestoTest {
    private static final Logger LOG = Logger.getLogger(PuestoTest.class.getName());

    @Test
    public void datosCompletos(){

        LOG.info("Iniciando test de datosCompletos");

        var puesto = new Puesto(1, 1, Estado.LIBRE);

        assertEquals(1, puesto.getPosicionI());
        assertEquals(1, puesto.getPosicionJ());
        assertEquals(Estado.LIBRE, puesto.getEstado());
        assertEquals(null, puesto.getVehiculo());

        LOG.info("Finalizando test de datosCompletos");

    }

    @Test 
    public void datosNegativosYnulos(){

        LOG.info("Iniciando test de datosNegativosYnulos");

        assertThrows(Throwable.class, () -> new Puesto(-1, -1, null));
        
        LOG.info("Finalizando test de datosNegativosYnulos");
        
    }
    
}
