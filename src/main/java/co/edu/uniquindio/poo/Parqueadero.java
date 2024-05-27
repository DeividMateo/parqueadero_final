package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;

public class Parqueadero {
    private final String nombre;
    private int numeroPuestos;
    private Collection<Registro> registros;
    private Collection<Vehiculo> vehiculos;

    public Parqueadero(String nombre, int numeroPuestos){

        assert nombre != null && !nombre.isBlank() , "El nombre no puede estar en blanco ni ser Null";
        assert numeroPuestos > 0 , "El numero de puestos tiene que ser mayor que cero";
        this.nombre = nombre;
        this.numeroPuestos = numeroPuestos;
        registros= new LinkedList<>();
        puestos  = new  Hastable<>();
        vehiculos= new LinkedList<>();
        crearPuestos(numeroPuestos);
    }

    public void crearPuestos(int numeroPuestos) {
        for (int i = 0; i < numeroPuestos; i++) {
            int posicionI = (i + 1);
            for (int j = 0; j < numeroPuestos; j++) {
                int posicionJ = (j + 1);
                String k = "(" + posicionI + ", " + posicionJ + ")";
                puestos.put(k, new Puesto(posicionI, posicionJ, Estado.LIBRE));
            }
        }
    }

    public void addVehiculoPuestoDado(Vehiculo vehiculo, int posicionI, int posicionJ) {
        ASSERTION.assertion(verificarPuestoDisponible(posicionI, posicionJ) == true,
                "Error: el puesto se encuentra ocupado");
        if (verificarPuestoDisponible(posicionI, posicionJ)) {
            var puesto = puestos.get("(" + posicionI + ", " + posicionJ + ")");
            puesto.setVehiculo(vehiculo);
            actualizarEstadoPuesto(posicionI, posicionJ, Estado.OCUPADO);
            LocalDateTime fechaEntrada = LocalDateTime.now();
            Registro nuevoRegistro = new Registro(fechaEntrada, null, vehiculo);
            registros.add(nuevoRegistro);
            addVehiculo(vehiculo);
        }
    }

    public boolean verificarPuestoDisponible(int i, int j) {
        var puesto = puestos.get("(" + i + ", " + j + ")");
        if (puesto != null) {
            if (puesto.getEstado().equals(Estado.LIBRE)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método privado para actualizar el estado de un puesto en especifico
     * 
     * @param posicionI   posición I del puesto al que se le desea actualizar el
     *                    estado
     * @param posicionJ   posición J del puesto al que se le desea actualizar el
     *                    estado
     * @param estadoNuevo nuevo estado del puesto al que se le desea cambiar el
     *                    estado
     */
    private void actualizarEstadoPuesto(int posicionI, int posicionJ, Estado estadoNuevo) {
        Estado estado = Estado.LIBRE;
        var puesto = puestos.get("(" + posicionI + ", " + posicionJ + ")");
        if (puesto.getEstado().equals(estado)) {
            puesto.setEstado(estadoNuevo);
        }
    }

    /**
     * Método para identificar el propietario de un vehiculo ubicado en un puesto
     * dado
     * 
     * @param posicionI posición I del vehiculo que se desea buscar
     * @param posicionJ posición J del vehiculo que se desea buscar
     * @return propietario del vehiculo ubicado en el puesto buscado o null de ser
     *         el caso de no obtener un propietario del vehiculo
     */
    public Propietario identificarPropietarioPuestoDado(int posicionI, int posicionJ) {
        ASSERTION.assertion(verificarPuestoDisponible(posicionI, posicionJ) == false,
                "Error: el puesto se encuentra libre");
        var puesto = puestos.get("(" + posicionI + ", " + posicionJ + ")");
        if (puesto != null) {
            if (puesto.getEstado().equals(Estado.OCUPADO)) {
                var vehiculo = puesto.getVehiculo();
                return vehiculo.getPropietario();
            }
        }
        return null;
    }

    /**
     * Método para adicionar un vehiculo a la colección de vehiculos
     * 
     * @param vehiculo vehiculo que se desea adicionar
     */
    public void addVehiculo(Vehiculo vehiculo) {
        ASSERTION.assertion(!verificarVehiculo(vehiculo.getPlaca()), "Error: el vehiculo ya se encuentra registrado");

        vehiculos.add(vehiculo);
    }

    /**
     * Método privado para determinar si ya existe otro vehiculo con la placa
     * indicada
     * 
     * @param placa placa que se desea verificar si existe o no de un vehiculo.
     * @return valor lógico que indica si existe o no un vehiculo con la placa
     *         indicada
     */
    private boolean verificarVehiculo(String placa) {
        Predicate<Vehiculo> placaIgual = vehiculo -> vehiculo.getPlaca().equals(placa);
        return vehiculos
                .stream()
                .filter(placaIgual)
                .findAny()
                .isPresent();
    }

    /**
     * Método para generar un reporte diario del dinero recaudado en el parqueadero
     * y desglosando según el vehiculo (Carro, Moto híbrida y Moto clásica)
     * 
     * @param fecha fecha del dia que se desea generar el reporte
     * @return colección del dinero recaudado y desglosado según el vehiculo
     */
    public Collection<Double> generarReporteDiario(LocalDate fecha) {
        double dineroRecaudadoCarro = 0.0;
        double dineroRecaudadoMotoHibrida = 0.0;
        double dineroRecaudadoMotoClasica = 0.0;

        for (Registro registro : registros) {
            if (registro.getFechaEntrada().toLocalDate().isEqual(fecha) && registro.getFechaSalida() != null) {
                var vehiculo = registro.getVehiculo();
                double tarifa = registro.calcularTarifa();

                if (vehiculo instanceof Carro) {
                    dineroRecaudadoCarro += tarifa;
                } else if (vehiculo instanceof Moto moto) {
                    if (moto.getTipoMoto() == TipoMoto.CLASICA) {
                        dineroRecaudadoMotoClasica += tarifa;
                    } else {
                        dineroRecaudadoMotoHibrida += tarifa;
                    }

                }
            }
        }
        Collection<Double> reporteDiario = new LinkedList<>();
        reporteDiario.add(dineroRecaudadoCarro);
        reporteDiario.add(dineroRecaudadoMotoClasica);
        reporteDiario.add(dineroRecaudadoMotoHibrida);

        return Collections
                .unmodifiableCollection(reporteDiario);
    }

    /**
     * Método para generar un reporte mensual del dinero recaudado en el parqueadero
     * 
     * @param mes mes (con año) al que se desea generar un reporte
     * @return double del total de dinero recaudado en el mes buscado
     */
    public double generarReporteMensual(YearMonth mes) {
        double dineroRecaudado = 0.0;
        int año = mes.getYear();
        int mesBuscado = mes.getMonthValue();
        for (Registro registro : registros) {
            if (registro.getFechaEntrada().toLocalDate().getYear() == año
                    && registro.getFechaEntrada().toLocalDate().getMonthValue() == mesBuscado) {
                dineroRecaudado += registro.calcularTarifa();
            }
        }
        return dineroRecaudado;
    }

    /**
     * Método para obtener el nombre del parqueadero creado
     * 
     * @return nombre del parqueadero creado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener el numero de puestos del parqueadero creado
     * 
     * @return numero de puestos del parqueadero creado
     */
    public int getNumeroPuestos() {
        return numeroPuestos;
    }

    /**
     * Método para obtener la colección de registros añadidos en el parqueadero
     * 
     * @return colección de registros añadidos en el parqueadero
     */
    public Collection<Registro> getRegistros() {
        return Collections
                .unmodifiableCollection(registros);
    }

    /**
     * Método para obtener los puestos del parqueadero creado
     * 
     * @return puestos del parqueadero creado
     */
    public Hashtable<String, Puesto> getPuestos() {
        return puestos;
    }

    /**
     * Método para obtener la colección de vehiculos añadidos al parqueadero creado
     * 
     * @return colección de vehiculos añadidos al parqueadero creado
     */
    public Collection<Vehiculo> getVehiculos() {
        return Collections
                .unmodifiableCollection(vehiculos);
    }
}


