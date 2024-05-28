package co.edu.uniquindio.poo;

public class Propietario {
    
    private final String nombres;
    private final String apellidos;
    private final int edad;
    private final String celular;
    private final String correo;
    
    
    public Propietario(String nombres, String apellidos, int edad, String celular, String correo) {

        if (nombres == null || nombres.trim().isEmpty() ||
        apellidos == null || apellidos.trim().isEmpty() ||
        celular == null || celular.trim().isEmpty() ||
        correo == null || correo.trim().isEmpty()) {
        throw new IllegalArgumentException("Los datos del propietario no pueden ser nulos o vacíos");
        }
        if (edad < 18) {
        throw new IllegalArgumentException("El propietario debe ser mayor de edad");
        }
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.celular = celular;
        this.correo = correo;
    }

    public String getNombres() {
        return nombres;
    }


    public String getApellidos() {
        return apellidos;
    }


    public int getEdad() {
        return edad;
    }


    public String getCelular() {
        return celular;
    }


    public String getCorreo() {
        return correo;
    }

    


    

    
}
