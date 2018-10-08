package programabancario;

import javax.swing.JOptionPane;

public class Rutinas {

    static Cliente clientes[] = new Cliente[4];
    static Prestamo prestamos[] = new Prestamo[4];
    static Cuenta cuenta[] = new Cuenta[4];
    static boolean encontrado = false;

    static int demeNumI(String msj) { //Pedir Enteros
        String s = JOptionPane.showInputDialog(null, msj, "Digite lo que se le solicita", JOptionPane.QUESTION_MESSAGE);
        int n = Integer.parseInt(s);
        while (n <= -1) {//Validacion
            JOptionPane.showMessageDialog(null, "El número digitado es incorrecto");
            s = JOptionPane.showInputDialog(null, msj, "Digite lo que se le solicita", JOptionPane.QUESTION_MESSAGE);
            n = Integer.parseInt(s);
        }
        return n;
    }

    static float demeNumF(String msj) { // Pedir Montos
        String s = JOptionPane.showInputDialog(null, msj, "Digite lo que se le solicita", JOptionPane.QUESTION_MESSAGE);
        float n = Float.parseFloat(s);
        while (n <= -1) {//Validacion
            JOptionPane.showMessageDialog(null, "El número digitado es incorrecto");
            s = JOptionPane.showInputDialog(null, msj, "Digite lo que se le solicita", JOptionPane.QUESTION_MESSAGE);
            n = Float.parseFloat(s);
        }
        return n;
    }

    static String demeTex(String msj) { // Pedir Palabras
        String s = JOptionPane.showInputDialog(null, msj, "Digite lo que se le solicita", JOptionPane.QUESTION_MESSAGE);
        return s;
    }

    public static String textoMenuP() { //Al agregar un nuevo tipo de Prestamo el MenuPrincipal cambiara el menu secundario de prestamos
        String s = "";
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i].tipoPrestamos != null) {
                s += i + 1 + ". " + prestamos[i].tipoPrestamos + "\n";
            }
        }
        s += "Si lo que desea agregar un nuevo tipo de Prestamo digite el 0";
        return s;
    }

    public static void llenaCliente() { //String nombre, int id, Cuenta numCuenta, int numTelefono, int numCelular, String correoCliente, String direccion
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente();
        }
        clientes[0] = new Cliente("Ronald Blanco", 1234, cuenta[0], 25253512, 60617894, "ronald@hotmail.com", "San Rafael, Oreamuno");
        clientes[1] = new Cliente("Josue Umaña", 123, cuenta[1], 25253512, 69617894, "josue@hotmail.com", "Paraiso, Cartago");
        clientes[2] = new Cliente("Brayner Castro", 987, cuenta[2], 25253512, 80617894, "brayner@hotmail.com", "San Blas, Cartago");

    }

    public static void llenaCuentas() {//int idCuenta, double monto, int numTarjeta, String fechaVencimiento, int claveTarjeta
        for (int i = 0; i < cuenta.length; i++) {
            cuenta[i] = new Cuenta();
        }
        cuenta[0] = new Cuenta(123, 250000, 12341234, "03/22", 0101);
        cuenta[1] = new Cuenta(234, 150000, 98749874, "01/19", 0101);
        cuenta[2] = new Cuenta(345, 10000, 65416541, "10/18", 0101);

    }

    public static void llenaPrestamos() {//LLenar TODOS los campos de prestamo

        for (int i = 0; i < prestamos.length; i++) {
            prestamos[i] = new Prestamo();
        }
        prestamos[0] = new Prestamo("Estudios Universitarios", 15000000, "Tener el titulo de bachillerato \n Traer plan de estudios de la univerdisidad\n Tener un fiador", "10 años desde que se termina el bachillerato de la carrera");
        prestamos[1] = new Prestamo("Pequeña empresa", 50000000, "Traes la nomina de empleaños con sus respectivos puestos \n Tipo de empresa \n Depende del riesgo es el dinero que se le brindara", "5-10-15 años");
        prestamos[2] = new Prestamo("Comprar casa", 150000, "Traer dos fiadores\n Orden patronal", "5-10-15 años");

    }

    public static void nuevoTipoPrestamo() { //Agregar un nuevo prestamo 
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i].tipoPrestamos == null) {
                prestamos[i] = new Prestamo(demeTex("Digite el nombre del tipo de prestamo"), demeNumI("Digite el monto maximo para este tipo de prestamo"), demeTex("Digite todas las condiciones del prestamo"), demeTex("Digite los plazos para este tipo de prestamo"));
                break;
            }
        }
    }

    public static void nuevoCliente() {
        for (int i = 0; i < cuenta.length; i++) {
            if (cuenta[i].idCuenta == 0) {
                cuenta[i] = new Cuenta(demeNumI("Digite el id de cuenta para el nuevo cliente"), demeNumF("Digite el monto inicial que depositara el cliente"), demeNumI("Digite el numero de la tarjeta que se le dra al cliente"), demeTex("Digite la fecha de vencimiento de la tarjeta"), demeNumI("Digite la clave de la tarjeta"));
                clientes[i] = new Cliente(demeTex("Digite el nombre del cliente"), demeNumI("Digite id del cliente"), cuenta[i], demeNumI("Digite número de habitación del cliente"), demeNumI("Digite el numero celular del cliente"), demeTex("Digite el correo del cliente"), demeTex("Digite la direccion del cliente"));
                break;
            }
        }
    }

    public static void eliminarCliente(int id) {

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].id == id) {
                clientes[i].id = 0;
                cuenta[i].setIdCuenta(0);

                JOptionPane.showMessageDialog(null, "El número de cuenta y el cliente han sido borrados");
                encontrado = true;
                break;
            }

        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "El número de cuenta y el cliente no existen", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void buscarCuenta(int id) {
        for (int i = 0; i < cuenta.length; i++) {
            if (cuenta[i].idCuenta == id) {
                JOptionPane.showMessageDialog(null, cuenta[i]);
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "El número de cuenta  no existen", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void buscarCliente(int id) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].id == id) {
                JOptionPane.showMessageDialog(null, clientes[i]);
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "El cliente no existen", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void agregarDinero(int id) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].id == id) {
                float depositar = demeNumF("Digite la cantidad de dinero que el usuario va a depositar");
                clientes[i].numCuenta.setMonto(depositar); //Se le suma el monto depositado
                encontrado = true;
                break;

            }
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "El cliente no existen", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static void sacarDinero(int id) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].id == id) {
                float retirar = demeNumF("Digite la cantidad de dinero que el usuario va a retirar");
                if (retirar <= clientes[i].numCuenta.getMonto()) { //Se valida si tiene el dinero suficiente
                    clientes[i].numCuenta.setMonto(retirar*-1);
                    encontrado = true;
                    break;
                } else { //si no tuviera el dinero suficiente
                    while (retirar < clientes[i].numCuenta.getMonto()) {
                        JOptionPane.showMessageDialog(null, "El monto que desea retirar el usuario es más de lo que tiene\n Pida otro monto o digite 0 para cancelar la accion", "ERROR", JOptionPane.ERROR_MESSAGE);
                        retirar = demeNumF("Digite la cantidad de dinero que el usuario va a retirar");
                    }
                    clientes[i].numCuenta.setMonto(retirar*-1);
                    encontrado = true;
                }
            }
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "El cliente no existen", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void balance(int id) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].id == id) {
                JOptionPane.showMessageDialog(null, "El monto disponible para el cliente es de " + clientes[i].numCuenta.getMonto());
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "El cliente no existen", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void menuPrincipal() {
        String msj = "Digite la opción que desee realizar \n 1. Clientes \n 2.Retirar o depositar en una cuenta \n 3. Tipos de prestamos \n 4. Transacciones  \n 5. Para salir";
        int op = 0;
        int op1;
        while (op != 5) {
            op = demeNumI(msj);
            switch (op) {
                case 1: //Cliente
                    op1 = demeNumI("Digite la opcion que desea realizar \n 1. Buscar cliente \n 2. Buscar cuenta \n 3. Agregar cliente\n 4. Eliminar cliente");
                    switch (op1) {
                        case 1: //Imprimir un cliente
                            buscarCliente(demeNumI("Digite el número de cedula del cliente que sea encontrar"));
                            break;
                        case 2: //Imprime una cuenta
                            buscarCuenta(demeNumI("Digite el número cuenta que sea encontrar"));
                            break;
                        case 3: //Agregar a un cliente
                            nuevoCliente();
                            break;
                        case 4: //Eliminar cliente
                            eliminarCliente(demeNumI("Digite el número de cedula del cliente que desea eliminar"));
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "El número digitado no corresponde a ninguna opción", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }//fin switch secundario cliente
                    break;
                case 2: //Retirar o depositar
                    op1 = demeNumI("Digite la opcion que desea realizar \n 1. Deposito \n 2. Retirar \n 3. Balance de la cuenta");
                    switch (op1) {
                        case 1:
                            agregarDinero(demeNumI("Digite el número de cedula del cliente que desea depositar en su cuenta"));
                            break;
                        case 2:
                            sacarDinero(demeNumI("Digite el número de cedula del cliente que desea retirar dinero"));
                            break;
                        case 3:
                            balance(demeNumI("Digite el número de cedula del cliente que desea saber la cantidad disponible en la cuenta"));
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "El número digitado no corresponde a ninguna opción", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } //Fin del switch secundario transacciones del cliente
                    break;
                case 3: //Tipos de prestamos
                    op1 = demeNumI("Digite el número del tipo de prestamo que desea saber\n" + textoMenuP());
                    if (op1 > prestamos.length || prestamos[op1].tipoPrestamos == null || op1 < 0) {
                        JOptionPane.showMessageDialog(null, "El número digitado no corresponde a ninguna opción", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else if (op1 != 0) {
                        JOptionPane.showMessageDialog(null, prestamos[op1 - 1]);
                    } else {
                        nuevoTipoPrestamo();
                    }
                    break;
                case 4: //Transacciones
                    Transaccion.menuServicios(demeNumI("Digite el número de cedula del cliente que desea realizar algun servicio"));
                    break;
                
                case 5:
                    JOptionPane.showMessageDialog(null, "Muchas gracias por su tiempo", "FIN", JOptionPane.DEFAULT_OPTION);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "El número digitado no corresponde a ninguna opción", "ERROR", JOptionPane.ERROR_MESSAGE);
            } //Fin del switch principal
        }//Fin del while

    }
}
