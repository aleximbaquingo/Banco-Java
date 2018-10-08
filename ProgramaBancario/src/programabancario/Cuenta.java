

package programabancario;


public class Cuenta {
    int idCuenta;
    private float monto;
    private int numTarjeta;
    private String fechaVencimiento;
    private int claveTarjeta;

    public Cuenta() {
    }

    public Cuenta(int idCuenta, float monto, int numTarjeta, String fechaVencimiento, int claveTarjeta) {
        this.idCuenta = idCuenta;
        this.monto = monto;
        this.numTarjeta = numTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.claveTarjeta = claveTarjeta;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    
    
    public int getClaveTarjeta() {
        return claveTarjeta;
    }

    public void setClaveTarjeta(int claveTarjeta) {
        this.claveTarjeta = claveTarjeta;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto += monto;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Numero de cuenta: " + idCuenta + "\n Monto en la cuenta: " + monto + "\n Numero de Tarjeta: " + numTarjeta + "\nFecha de Vencimiento: " + fechaVencimiento + "\n Clave de  la tarjeta: " + claveTarjeta;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
