

package programabancario;


public class Cliente {
    
String nombre;
int id;
Cuenta numCuenta;
int numTelefono;
int numCelular;
String correoCliente;
String direccion;
    public Cliente() {
    }

    public Cliente(String nombre, int id, Cuenta numCuenta, int numTelefono, int numCelular, String correoCliente, String direccion) {
        this.nombre=nombre;
        this.id = id;
        this.numCuenta=numCuenta;
        this.numTelefono = numTelefono;
        this.numCelular = numCelular;
        this.correoCliente = correoCliente;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cuenta getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(Cuenta numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public int getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(int numCelular) {
        this.numCelular = numCelular;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
 
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public String toString() { //Informacion del cliente
        return "Cliente: " + nombre + "\n id: " + id + "\n Número de cuenta: " + numCuenta + "\n Telefono de habitación: " + numTelefono + "\n Número celular: " + numCelular + "\n Correo electronico: " + correoCliente + "\n Dirección: " + direccion;
    }




}
