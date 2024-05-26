package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;


public class Puesto {

    private final int posicionI;
    private final int posicionJ;
    private Estado estado;
    private Vehiculo vehiculo;

    public Puesto(int posicionI, int posicionJ, Estado estado) {
        ASSERTION.assertion(posicionI > 0,
                "Error: la posicion I debe ser mayor a cero");
        ASSERTION.assertion(posicionJ > 0,
                "Error: la posicion I debe ser mayor a cero");
        ASSERTION.assertion(estado != null, "Error: el estado no puede ser nulo");
        this.posicionI = posicionI;
        this.posicionJ = posicionJ;
        this.estado = estado;
    }

        public int getPosicionI() {
            return posicionI;
        }

        public int getPosicionJ() {
            return posicionJ;
        }

        public Estado getEstado() {
            return estado;
        }

        public void setEstado(Estado estadoNuevo){
            this.estado = estadoNuevo;
        }

        public Vehiculo getVehiculo(){
            return vehiculo;
        }

        public void setVehiculo(Vehiculo vehiculo){
            this.vehiculo = vehiculo;
        }

}
