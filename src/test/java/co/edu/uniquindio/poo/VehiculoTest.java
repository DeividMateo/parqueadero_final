package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class VehiculoTest { 

    private static  final Logger LOG = Logger.getLogger(VehiculoTest.class.getName());


    @Test 
    public void datosCompletosMoto(){

        LOG.info("Iniciando Test DatosCompletosMoto");

        var propietario = new Propietario("Jose", "Gomez",25,"3103844890","JoseG@gmail.com");
        var moto = new Moto("ACD045", "Gisxxer250sf", propietario, 154 , TipoMoto.CLASICA);

        assertEquals("ACD045", moto.getPlaca());
        assertEquals("Gisxxer250sf", moto.getModelo());
        assertEquals(propietario, moto.getPropietario());
        assertEquals(154, moto.getVelocidadMaxima());
        assertEquals(TipoMoto.CLASICA, moto.getTipoMoto());

        LOG.info("Finalizando Test DatosCompletosMoto");



    }


    @Test
    public void datosCompletosCarro(){

        LOG.info("Iniciando Test DatosCompletosCarro");

        var propietario = new Propietario("Jose", "Gomez",25,"3103844890", "JoseG@gmail.com");
        var carro = new Carro("DSA432","Audi 2023",propietario);

        assertEquals("DSA432", carro.getPlaca());
        assertEquals("Audi 2023", carro.getModelo());
        assertEquals(propietario, carro.getPropietario());

        LOG.info("Finalizando Test DatosCompletosCarro");


    }

    @Test
    public void datosnulosMoto(){

        
    }


    
}
