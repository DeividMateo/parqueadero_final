/**
 * La clase Propietario representa a un propietario de un objeto o propiedad.
 * Cada propietario tiene un nombre, apellido, edad, número de celular y correo electrónico.
 * 
 * @author Deivid Mateo Cañan, Kevin Lopez, Nicolas Loaiza
 * @version 1.0
 */
package co.edu.uniquindio.poo;

public class Propietario {
    
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final String celular;
    private final String correo;

     /**
     * Crea un nuevo Propietario con los detalles proporcionados.
     *
     * @param nombre   El nombre del propietario. No puede ser null ni estar en blanco.
     * @param apellido El apellido del propietario. No puede ser null ni estar en blanco.
     * @param edad     La edad del propietario. Debe ser mayor que 0.
     * @param celular  El número de celular del propietario. No puede ser null ni estar en blanco.
     * @param correo   El correo electrónico del propietario. Debe contener el símbolo @.
     */
    
    
    
    public Propietario(String nombre, String apellido, int edad, String celular, String correo) {
        assert nombre != null && !nombre.isBlank() : "El nombre no puede estar en blanco ni ser null";
        assert apellido != null && !nombre.isBlank() : "El apellido no puede estar en blanco ni ser null";
        assert  edad >= 18 : "La edad debe ser mayor que 0";
        assert celular != null && !nombre.isBlank() : "El celular no puede estar en blanco ni ser null";
        assert correo != null && correo.contains("@") : "El correo electrónico debe contener el símbolo @";
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.correo = correo;
    }
  /**
     * Devuelve el nombre del propietario.
     *
     * @return El nombre del propietario.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Devuelve el apellido del propietario.
     *
     * @return El apellido del propietario.
     */


    public String getApellido() {
        return apellido;
    }
  /**
     * Devuelve la edad del propietario.
     *
     * @return La edad del propietario.
     */

    public int getEdad() {
        return edad;
    }
/**
     * Devuelve el celular del propietario.
     *
     * @return el celular del propietario.
     */

    public String getCelular() {
        return celular;
    }
/**
     * Devuelve el correo del propietario.
     *
     * @return el correp del propietario.
     */

    public String getCorreo() {
        return correo;
    }

    


    

    
}



