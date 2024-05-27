package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {

    private static double tarifa;

    /**
     * Método constructor de la clase Carro
     * 
     * @param placa       valor de la placa del carro
     * @param modelo      valor del modelo del carro
     * @param propietario valor del propietario del carro
     */
    public Carro(final String placa, final String modelo, final Propietario propietario) {
        super(placa, modelo, propietario);
    }

    /**
     * Método para obtener la tarifa del vehículo
     * 
     * @return tarifa del vehiculo al que se le desea obtener la tarifa
     */
    @Override
    public double getTarifa() {
        return tarifa;
    }

    /**
     * Método para cambiar la tarifa de un vehiculo y se le cambie a todas las
     * instancias de este
     */
    @Override
    public void setTarifa(double tarifa) {
        assert tarifa > 0.0 : "la tarifa debe ser mayor a cero";
        Carro.tarifa = tarifa;
    }
}
