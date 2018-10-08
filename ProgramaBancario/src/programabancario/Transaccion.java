package programabancario;

import javax.swing.JOptionPane;
import static programabancario.Rutinas.clientes;

public class Transaccion {

    static String transaccion[] = {"AYA", "ICE Electrico", "ICE Telefonico", "Recarga Movistar", "Recarga Claro", "Recarga Kolbi"};
    Cuenta idCuenta;
    float idTransaccion;

    float montoPagar;

    public Transaccion() {
    }

    public Transaccion(Cuenta idCuenta, float idTransaccion, float montoPagar) {
        this.idCuenta = idCuenta;
        this.idTransaccion = idTransaccion;

        this.montoPagar = montoPagar;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

    public float getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(float idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public float getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(float montoPagar) {
        this.montoPagar = montoPagar;
    }

    public static String textoMenuS() { //Al agregar un nuevo tipo de Prestamo el MenuPrincipal cambiara el menu secundario de prestamos
        String s = "";
        for (int i = 0; i < transaccion.length; i++) {

            s += i + 1 + ". " + transaccion[i] + "\n";
        }

        return s;
    }

    public static void menuServicios(int id) {
        boolean encontrado = false;
        for (int i = 0; i < clientes.length; i++) {

            if (clientes[i].id == id) {
                encontrado = true;
                int op = Rutinas.demeNumI(textoMenuS());
                if (op < 0 || op > 6) { //Validar
                    JOptionPane.showMessageDialog(null, "El número digitado no corresponde a ninguna opción", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (op >= 3) { //Servicios del hogar
                    Rutinas.demeNumI("Digite su número de servicio para el servicio " + transaccion[op - 1]);
                    int deuda = (int) (Math.random() * 40000) + 1;
                    int pagar = Rutinas.demeNumI("El monto a pagar es de: " + deuda + "\n Seleccione 1 para pagar \n 2. Para cancelar");
                    if (pagar == 1) {
                        if (Rutinas.clientes[i].numCuenta.getMonto() < pagar) {
                            JOptionPane.showMessageDialog(null, "No se tienen suficientes fondos para realizar el pago", "ERROR", JOptionPane.ERROR_MESSAGE);
                        } else {
                            Rutinas.clientes[i].numCuenta.setMonto(pagar * 1);
                        }
                    }
                } else if (op > 3) { //Recargas telefonicas
                    Rutinas.demeNumI("Digite el número de telefono para " + transaccion[op - 1]);
                    int pagar = Rutinas.demeNumI("Digite el monto que desea recargar");

                    if (Rutinas.cuenta[i].getMonto() < pagar) {
                        JOptionPane.showMessageDialog(null, "No se tienen suficientes fondos para realizar el pago", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        pagar *= -1;
                        Rutinas.clientes[i].numCuenta.setMonto(pagar);
                    }
                }

            }
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "El cliente no existen", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }
}
