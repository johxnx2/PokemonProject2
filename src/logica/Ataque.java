package logica;

public class Ataque {
    private String nombre;
    private int costo;
    private int danio;
    private TipoElementos tipoBono;
    private int bono;

    public Ataque(String nombre, int costo, int danio) {
        this.nombre = nombre;
        this.costo = costo;
        this.danio = danio;
    }

    public Ataque(String nombre, int costo, int danio, TipoElementos tipoBono, int bono) {
        this(nombre, costo, danio);
        this.tipoBono = tipoBono;
        this.bono = bono;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCosto() {
        return costo;
    }

    public int getDanio() {
        return danio;
    }

    public TipoElementos getTipoBono() {
        return tipoBono;
    }

    public int getBono() {
        return bono;
    }
}
