package logica.pokemones;

import java.util.ArrayList;
import logica.Ataque;
import logica.Carta;
import logica.Jugador;
import logica.TipoCarta;
import logica.TipoElementos;

public abstract class Pokemon extends Carta{
//constructor
    public Pokemon(String nombre, TipoCarta tipoCarta, TipoElementos tipo, int ps, boolean isEX, boolean isActive, boolean isEvo) 
    {
    super(nombre, tipoCarta);{

        this.tipo = tipo;
        this.ps = ps;
        this.isEX = isEX;
        this.isActive = isActive;
        this.isEvo=isEvo;
        this.costoRetirada = isEX ? 3 : 1;
    }
}


//atributo
    protected int danioAcumulado = 0;
    protected boolean isEvo;
    protected  TipoElementos tipo;
    protected  int ps;
    protected boolean isEX;
    protected int EnergiaAcumulada;
    protected boolean isActive;
    protected boolean turboVelocidadUsada=false;
    protected ArrayList<Ataque> ataques = new ArrayList<>();
    protected boolean evolucionBloqueada = false;
    protected int costoRetirada;

    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }

    public boolean isEvolucionBloqueada() {
        return evolucionBloqueada;
    }

    public void setEvolucionBloqueada(boolean evolucionBloqueada) {
        this.evolucionBloqueada = evolucionBloqueada;
    }

    public boolean isTurboVelocidadUsada() {
        return turboVelocidadUsada;
    }

    public void setTurboVelocidadUsada(boolean turboVelocidadUsada) {
        this.turboVelocidadUsada = turboVelocidadUsada;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    //set y get
    public TipoElementos getTipoP() {
        return tipo;
    }
    public void setDanioAcumulado(int n){
        this.danioAcumulado = n + getDanioAcumulado();
    }
    public int getDanioAcumulado(){
        return danioAcumulado;
    }
    
    public void setEnergiaAcumulada(int x){
        this.EnergiaAcumulada= x;
    }

    public int getEnergiaAcumulada(){
        return EnergiaAcumulada;
    }

    public void setTipoElementos(TipoElementos tipo) {
        this.tipo = tipo;
    }

    public int getPs() {
        return ps;
    }
    public void setPs(int ps) {
        this.ps = ps;
    }

    public boolean isEX() {
        return isEX;
    }
    public void setEX(boolean isEX) {
        this.isEX = isEX;
    }

//--------
//metodo abstrato

    public void atacar(int indice, Pokemon objetivo) {
        Ataque ataque = ataques.get(indice);
        if (this.getEnergiaAcumulada() >= ataque.getCosto()) {
            int danio = ataque.getDanio();
            
            if (objetivo.getTipoP() == ataque.getTipoBono()) {
                danio = danio + ataque.getBono();
            }
            objetivo.setDanioAcumulado(danio);
            objetivo.setPs(objetivo.getPs() - danio);
            System.out.println(this.getNombreCarta()+ " ataca\n"+"causa "+ danio +" de daño a "+objetivo.getNombreCarta()+"\nVida actual de "+objetivo.getNombreCarta()+" es "+
            (objetivo.getPs() > 0 ? objetivo.getPs(): 0) );
        } else {
            System.out.println("No tiene suficiente energia para atacar");
        }
    }

//METODO RETIRADA
    
    public boolean PuedeRetirada(){
        int costo = this.turboVelocidadUsada ? costoRetirada - 1 : costoRetirada;
        if(this.getEnergiaAcumulada()>=costo){
            this.setEnergiaAcumulada(this.getEnergiaAcumulada()-costo);
            return true;
        }else{
            return false;
        }
    }

public Pokemon retirar(Jugador jugador,int opc,Pokemon pokemon){
    Pokemon nuevoActivo = jugador.getBanco()[opc - 1];
    jugador.setBanco(null, opc-1);
    jugador.setBanco(pokemon, opc-1);
    
    return nuevoActivo ;
}
}
