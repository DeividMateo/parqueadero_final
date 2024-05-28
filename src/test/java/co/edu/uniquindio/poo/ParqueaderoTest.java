package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class ParqueaderoTest {
    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());

    @Test
    public void datosCompletos() {

        LOG.info("Iniciando test de datos Completos");

        var Parqueadero = new Parqueadero("ParqueaderoUnicentro", 20);

        assertEquals("ParqueaderoUnicentro", Parqueadero.getNombre());

        assertEquals(20, Parqueadero.getNumeroPuestos());

        LOG.info("Finalizando test de datos Completos");

    }

    @Test

    public void crearPuestos() {

        LOG.info("iniciando test para crear puestos");

        var parqueadero = new Parqueadero("ParqueaderoUnicentro", 20);

        assertEquals(400, parqueadero.getPuestos().size());
        LOG.info("Finalizando test para crear puestos");

    }

    @Test
    public void generaReporteSinVehiculos() {

        LOG.info("Iniciando test para generar reporte sin vehiculos");

        var parqueadero = new Parqueadero("ParqueaderoUnicentro", 20);

        LocalDate fecha = LocalDate.now();
        YearMonth mes = YearMonth.now();

        List<Double> reporteDiarioEsperado = List.of(0.0, 0.0, 0.0);
        Collection<Double> reporteDiario = parqueadero.generarReporteDiario(fecha);
        assertEquals(reporteDiarioEsperado, new LinkedList<>(reporteDiario));
        assertEquals(0, 0, parqueadero.generarReporteMensual(mes));

        LOG.info("Finalizando test para generar reporte sin vehiculos");
    }

    @Test
    public void agregarVehiculosDiferentes() {
        LOG.info("Iniciando Test para añadir vehiculos diferentes");

        var parqueadero = new Parqueadero("ParqueaderoUnicentro", 20);

        var propietario1 = new Propietario("Deivid", "cañan", 19, "3195051749", "deividC@gmail.com");

        var propietario2 = new Propietario("Kevin", " Lopez", 19, "3223848585", "KevinLp@gmail.com");

        var propietario3 = new Propietario("Nicolas ", "Loaiza", 19, "3103844890", "NicLo@gmail.com");

        var carro = new Carro("AVG033", "mazda 3", propietario1);

        var motoClasica = new Moto("JDF453", "Fz 2.0 ", propietario2, 122, TipoMoto.CLASICA);

        var motoHibrida = new Moto("MSF345", "BWS FI", propietario3, 125, TipoMoto.HIBRIDA);

        assertEquals(true, parqueadero.verificarPuestoDisponible(1, 1));
        parqueadero.addVehiculoPuestoDado(carro, 1, 1);
        assertEquals(false, parqueadero.verificarPuestoDisponible(1, 1));
        assertEquals(true, parqueadero.verificarPuestoDisponible(2, 2));
        parqueadero.addVehiculoPuestoDado(motoClasica, 2, 2);
        assertEquals(false, parqueadero.verificarPuestoDisponible(2, 2));
        assertEquals(true, parqueadero.verificarPuestoDisponible(3, 3));
        parqueadero.addVehiculoPuestoDado(motoHibrida, 3, 3);
        assertEquals(false, parqueadero.verificarPuestoDisponible(3, 3));

        LOG.info("Finalizando test de añadir vehiculos diferentes");

    }

    @Test

    public void agregarVehiculosIguales() {
        LOG.info("Iniciando Test para añadir vehiculos");

        var parqueadero = new Parqueadero("ParqueaderoUnicentro", 20);

        var propietario1 = new Propietario("Deivid ", "Cañan", 19, "3195051749", "deividc@gmail.com");

        var propietario2 = new Propietario("Kevin", "Lopez", 19, "3223848585", "KevinLp@gmail.com");

        var propietario3 = new Propietario("Nicolas", "Loaiza", 19, "3103844890", "NicLo@gmail.com");

        var carro = new Carro("AVG033", "mazda 3", propietario1);

        var motoClasica = new Moto("JDF453", "Fz 2.0 ", propietario2, 122, TipoMoto.CLASICA);

        var motoClasica2 = new Moto("JDF453", "Fz 2.0 ", propietario3, 122, TipoMoto.CLASICA);

        parqueadero.addVehiculoPuestoDado(carro, 3, 1);
        parqueadero.addVehiculoPuestoDado(motoClasica, 2, 2);

        assertEquals(false, parqueadero.verificarPuestoDisponible(3, 1));
        assertEquals(false, parqueadero.verificarPuestoDisponible(2, 2));
        
        assertThrows(Throwable.class, () -> parqueadero.addVehiculoPuestoDado(motoClasica2, 2, 2));

        LOG.info("Finalizando test de añadir vehiculos");

    }

    @Test

    public void generaReporteParqueaderoConVehiculos() {

        LOG.info("Iniciando test para generar reporte con vehiculos");

        var parqueadero = new Parqueadero("ParqueaderoUnicentro", 20);

        var administrador = new Administrador("Mateo", "Villegas", 28, "3122493490", "MateVille@gmail.com");

        var propietario1 = new Propietario("Deivid", "cañan", 19, "3195051749", "deividC@gmail.com");

        var propietario2 = new Propietario("Kevin", " Lopez", 19, "3223848585", "KevinLp@gmail.com");

        var propietario3 = new Propietario("Nicolas ", "Loaiza", 19, "3103844890", "NicLo@gmail.com");

        var carro = new Carro("AVG033", "mazda 3", propietario1);

        var motoClasica = new Moto("JDF453", "Fz 2.0 ", propietario2, 122, TipoMoto.CLASICA);

        var motoHibrida = new Moto("MSF345", "BWS FI", propietario3, 125, TipoMoto.HIBRIDA);

        administrador.cambiarTarifa(carro, 3500.0);
        administrador.cambiarTarifa(motoClasica, 2000.0);
        administrador.cambiarTarifa(motoHibrida, 2800.0);

        parqueadero.addVehiculoPuestoDado(carro, 1, 1);
        parqueadero.addVehiculoPuestoDado(motoClasica, 2, 2);
        parqueadero.addVehiculoPuestoDado(motoHibrida, 3, 3);

        LocalDate fecha = LocalDate.now();

        List<Double> reporteDiarioEsperado = List.of(3500.0, 2000.0, 2800.0);
        Collection<Double> reporteDiario = parqueadero.generarReporteDiario(fecha);

        assertIterableEquals(reporteDiarioEsperado, new LinkedList<>(reporteDiario));

        LOG.info("Finalizando test de generarReporteDiarioParqueaderoConVehiculos");

    }

}
