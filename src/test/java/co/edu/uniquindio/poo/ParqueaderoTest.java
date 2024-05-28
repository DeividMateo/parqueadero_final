package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
   public void datosCompletosParqueadero(){

    LOG.info("Iniciando test de datos Completos Parqueadero");

    var Parqueadero = new Parqueadero("ParqueoSeguro", 10);

    assertEquals("ParqueoSeguro", Parqueadero.getNombre());

    assertEquals(10, Parqueadero.getNumeroPuestos());

    LOG.info("Finalizando test de datos Completos Parqueadero");

   }

   @Test

   public void crearPuestos(){

    LOG.info("iniciando Test para Crear Puestos del Parqueadero ");

    var parqueadero = new Parqueadero("ParqueoSeguro", 10);

    assertEquals(100, parqueadero.getPuestos().size());
    LOG.info("Finalizando test para crear puestos del parqueadero ");


   }

    @Test 
    public void generarParqueaderoSinVehiculos(){

        LOG.info("Iniciando test para generar parqueadero sin vehiculos");

        var parqueadero = new Parqueadero("ParqueoSeguro", 10);

       
        LocalDate fecha = LocalDate.now();
        YearMonth mes = YearMonth.now();

        List<Double> reporteDiarioEsperado = List.of(0.0,0.0,0.0);
        Collection<Double> reporteDiario = parqueadero.generarReporteDiario(fecha);
        assertEquals(reporteDiarioEsperado, new LinkedList<>(reporteDiario));
        assertEquals(0,0, parqueadero.generarReporteMensual(mes));


        LOG.info("Finalizando test para generar parqueadero sin vehiculos");
    }

    @Test
    public void agregarVehiculosDiferentes(){
        LOG.info("Iniciando Test para añadir vehiculos diferentes al parqueadero");

        var parqueadero = new Parqueadero("ParqueoSeguro", 10);

        var propietario1 = new Propietario("Deivid","cañan", 19 ,"3195051749", "deividC@gmail.com");

        var propietario2 = new Propietario("Kevin", " Lopez",19 ,"3223848585", "KevinLp@gmail.com");

        var propietario3 = new Propietario("Nicolas ", "Loaiza", 19 ,"3103844890", "NicLo@gmail.com");

        var carro = new Carro("AVG033","mazda 3", propietario1 );

        var motoClasica = new Moto("JDF453","Fz 2.0 ",propietario2, 122,TipoMoto.CLASICA);

        var motoHibrida = new Moto("MSF345","BWS FI", propietario3, 125,TipoMoto.HIBRIDA);

        assertEquals(true, parqueadero.verificarPuestoDisponible(1, 1));
        parqueadero.addVehiculoPuestoDado(carro, 1, 1);
        assertEquals(false, parqueadero.verificarPuestoDisponible(1,1));
        assertEquals(true, parqueadero.verificarPuestoDisponible(2, 2));
        parqueadero.addVehiculoPuestoDado(motoClasica, 2, 2);
        assertEquals(false, parqueadero.verificarPuestoDisponible(2,2));
        assertEquals(true, parqueadero.verificarPuestoDisponible(3, 3));
        parqueadero.addVehiculoPuestoDado(motoHibrida, 3, 3);
        assertEquals(false, parqueadero.verificarPuestoDisponible(3,3));

        LOG.info("Finalizando test de añadir vehiculos diferentes al parqueadero");

    





        

    }


   

}









    

