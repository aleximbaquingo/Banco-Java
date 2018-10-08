
package programabancario;

public class Prestamo {
   String  tipoPrestamos;
   float monto;
   String condiciones;
   String plazo;

    public Prestamo() {
    }

    public Prestamo(String tipoPrestamos, float monto, String condiciones, String plazo) {
        this.tipoPrestamos = tipoPrestamos;
        this.monto = monto;
        this.condiciones = condiciones;
        this.plazo = plazo;
    }

    @Override
    public String toString() {
        return "Prestamos para " + tipoPrestamos + "\n Monto: " + monto + "\n Condiciones: " + condiciones + "\n Plazo: " + plazo;
    }
   
   
   
   
   
   
   
   
}
