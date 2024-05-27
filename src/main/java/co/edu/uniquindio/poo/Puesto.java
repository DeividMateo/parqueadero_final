package co.edu.uniquindio.poo;


public class Puesto {

    private final int posicionI;
    private final int posicionJ;
    private Estado estado;
    private Vehiculo vehiculo;

    public Puesto(int posicionI, int posicionJ, Estado estado) {
        assert posicionI > 0: "La posicionI tiene que ser mayor a cero "; 
        assert posicionJ > 0: "La posicionJ tiene que ser mayor a cero ";
       assert estado !=null : "El estado no puede ser Nulo";
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

    public void setEstado(Estado estadoNuevo) {
        this.estado = estadoNuevo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

}
