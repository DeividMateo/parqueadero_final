package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class AdministradorTest {
    private static final Logger LOG = Logger.getLogger(AdministradorTest.class.getName());
    
    @Test
    public void tarifaPositiva(){

        LOG.info("Iniciado test tarifaPositiva");

        var administrador = new Administrador("Mateo", "Villegas", 28, "3122493490", "MateVille@gmail.com");

        var propietario1 = new Propietario("Deivid", "cañan", 19, "3195051749", "deividC@gmail.com");
        var propietario2 = new Propietario("Kevin", " Lopez", 19, "3223848585", "KevinLp@gmail.com");
        var propietario3 = new Propietario("Nicolas ", "Loaiza", 19, "3103844890", "NicLo@gmail.com");
        var propietario4 = new Propietario("Anderson", "Lara", 20, "3147896520", "AndLa@gmail.com");

        var carro = new Carro("AYS27G", "Duster", propietario1);
        var motoClasica = new Moto("NEL47C", "MT 09 2024", propietario2, 200, TipoMoto.CLASICA);
        var motoHibrida = new Moto("MSD38G", "BWS FI", propietario3, 150, TipoMoto.HIBRIDA);
        var motoClasica2 = new Moto("KJB99J", "Gixxer 250", propietario4, 1540, TipoMoto.CLASICA);

        administrador.cambiarTarifa(carro, 3500.0);
        administrador.cambiarTarifa(motoClasica, 2000.0);
        administrador.cambiarTarifa(motoHibrida, 2800.0);

        assertEquals(2000.0, motoClasica2.getTarifa());
        assertEquals(3500.0, carro.getTarifa());
        assertEquals(2000.0, motoClasica.getTarifa());
        assertEquals(2800.0, motoHibrida.getTarifa());

        LOG.info("Finalizando test tarifaPositiva");

    }

    @Test
    public void tarifaNegativa(){

        LOG.info("Iniciado test tarifaNegativa");

        var administrador = new Administrador("Mateo", "Villegas", 28, "3122493490", "MateVille@gmail.com");

        var propietario1 = new Propietario("Deivid", "cañan", 19, "3195051749", "deividC@gmail.com");
        var propietario2 = new Propietario("Kevin", " Lopez", 19, "3223848585", "KevinLp@gmail.com");
        var propietario3 = new Propietario("Nicolas ", "Loaiza", 19, "3103844890", "NicLo@gmail.com");

        var carro = new Carro("AYS27G", "Duster", propietario1);
        var motoClasica = new Moto("NEL47C", "MT 09 2024", propietario2, 200, TipoMoto.CLASICA);
        var motoHibrida = new Moto("MSD38G", "BWS FI", propietario3, 150, TipoMoto.HIBRIDA);

        assertThrows(Throwable.class, () -> administrador.cambiarTarifa(carro, -3500.0));
        assertThrows(Throwable.class, () -> administrador.cambiarTarifa(motoClasica, -2000.0));
        assertThrows(Throwable.class, () -> administrador.cambiarTarifa(motoHibrida, -2800.0));

        LOG.info("Finalizando test tarifaNegativa");

    }
}
