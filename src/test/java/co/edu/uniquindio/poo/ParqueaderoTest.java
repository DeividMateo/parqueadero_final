package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public void generaReporteDiarioParqueaderoConVehiculos() {

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
        parqueadero.removeVehiculoPuestoDado(1, 1, LocalDateTime.now().plusHours(1));
        parqueadero.removeVehiculoPuestoDado(2, 2, LocalDateTime.now().plusHours(1));
        parqueadero.removeVehiculoPuestoDado(3, 3, LocalDateTime.now().plusHours(1));

        LocalDate fecha = LocalDate.now();

        List<Double> reporteDiarioEsperado = List.of(3500.0, 2000.0, 2800.0);
        Collection<Double> reporteDiario = parqueadero.generarReporteDiario(fecha);

        assertIterableEquals(reporteDiarioEsperado, new LinkedList<>(reporteDiario));

        LOG.info("Finalizando test de generarReporteDiarioParqueaderoConVehiculos");

    }

    @Test
    public void calcularTarifaDespuesdeXhoras() {
        LOG.info("Iniciando test para calcular tarifa despues de x horas");

        var parqueadero = new Parqueadero("ParqueoSeguro", 10);

        var administrador = new Administrador("Jose", "Gonzales ", 28, "3122493490", "JoseGon@gmail.com");

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

        parqueadero.removeVehiculoPuestoDado(1, 1, LocalDateTime.now().plusHours(8));
        parqueadero.removeVehiculoPuestoDado(2, 2, LocalDateTime.now().plusHours(8));
        parqueadero.removeVehiculoPuestoDado(3, 3, LocalDateTime.now().plusHours(8));

        LocalDate fecha = LocalDate.now();

        List<Double> reporteDiarioEsperado = List.of(28000.0, 16000.0, 22400.0);
        Collection<Double> reporteDiario = parqueadero.generarReporteDiario(fecha);

        assertEquals(reporteDiarioEsperado, new LinkedList<>(reporteDiario));

        LOG.info("Inicializando test de calcularTarifaDespuesDeXhoras");

    }

    @Test

    public void generarReporteMesual() {

        LOG.info("Iniciando test para generar reporte mensual");

        var parqueadero = new Parqueadero("ParqueoSeguro", 10);

        var administrador = new Administrador("Jose", "Gonzales ", 28, "3122493490", "JoseGonza@gmail.com");

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

        parqueadero.removeVehiculoPuestoDado(1, 1, LocalDateTime.now().plusDays(2));
        parqueadero.removeVehiculoPuestoDado(2, 2, LocalDateTime.now().plusHours(15));
        parqueadero.removeVehiculoPuestoDado(3, 3, LocalDateTime.now().plusMonths(1));

        YearMonth mes = YearMonth.now();

        /*
         * carro: 48h*3500.0 = 168000.0, motoClasica: 15h*2000.0 = 30000.0, motoHibrida:
         * 31d*24h = 744h| 744h*2800.0 = 2083200.0
         * Total: 168000.0 + 30000.0 + 2083200.0 = 2281200
         */
        assertEquals(2281200, parqueadero.generarReporteMensual(mes));

        LOG.info("Finalizando test de generarReporteMensual");

    } 

    @Test

    public void identificarPropietarioVehiculoPuestoDado(){
        LOG.info("Iniciando test para identificar propietario de vehiculo en puesto dado");

        var parqueadero = new Parqueadero("ParqueoSeguro", 10);

        var propietario1 = new Propietario("Deivid", "cañan", 19, "3195051749", "deividC@gmail.com");

        var carro = new Carro("AVG033", "mazda 3", propietario1);

        parqueadero.addVehiculoPuestoDado(carro, 1, 1);

        assertEquals(propietario1, parqueadero.identificarPropietarioPuestoDado(1, 1));

        LOG.info("Finalizando test de identificarPropietarioVehiculoPuesto");
        
    }








}
