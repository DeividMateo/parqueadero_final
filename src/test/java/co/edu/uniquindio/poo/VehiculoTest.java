package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class VehiculoTest { 

    private static  final Logger LOG = Logger.getLogger(VehiculoTest.class.getName());


    @Test 
    public void datosCompletosMoto(){

        LOG.info("Iniciando Test DatosCompletosMoto");

        var propietario = new Propietario("Nicolas", "Loaiza",29,"3103844890","NicoL@gmail.com");
        var moto = new Moto("IJL702", "Gixxer250", propietario, 154 , TipoMoto.CLASICA);

        assertEquals("IJL702", moto.getPlaca());
        assertEquals("Gixxer250", moto.getModelo());
        assertEquals(propietario, moto.getPropietario());
        assertEquals(154, moto.getVelocidadMaxima());
        assertEquals(TipoMoto.CLASICA, moto.getTipoMoto());

        LOG.info("Finalizando Test DatosCompletosMoto");



    }


    @Test
    public void datosCompletosCarro(){

        LOG.info("Iniciando Test DatosCompletosCarro");

        var propietario = new Propietario("Nicolas", "Loaiza",29,"3103844890","NicoL@gmail.com");
        var carro = new Carro("IJL702","Spark GT",propietario);

        assertEquals("IJL702", carro.getPlaca());
        assertEquals("Spark GT", carro.getModelo());
        assertEquals(propietario, carro.getPropietario());

        LOG.info("Finalizando Test DatosCompletosCarro");


    }

    @Test
    public void datosnulosMoto(){
        
        LOG.info("Iniciando Test datosnulosMoto");

        assertThrows(Throwable.class, () -> new Moto(null, null, null, 0, null));
        
        LOG.info("Finalizando Test datosnulosMoto");
        
    }

    @Test
    public void datosnulosCarro(){
        
        LOG.info("Iniciando Test datosnulosCarro");

        assertThrows(Throwable.class, () -> new Carro(null, null, null));
        
        LOG.info("Finalizando Test datosnulosCarro");
        
    }


    
}
