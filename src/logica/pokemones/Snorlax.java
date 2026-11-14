package logica.pokemones;

import logica.TipoElementos;
import logica.TipoCarta;

public class Snorlax extends Pokemon {
    public Snorlax () {
        super("Snorlax", TipoCarta.POKEMON, 100, 
        TipoElementos.INCOLORO, 150,  false, false,3, 0,false);
    }

    private String ataque1 = "Golpe Cuerpo";

    public String getAtaque1() {
        return ataque1;
    }
    @Override 
    public void atacar2(Pokemon objetivo){
        return; // Snorlax no tiene un segundo ataque
    }
    @Override
    public void atacar(Pokemon objetivo){
        int e=this.getEnergiaAcumulada();
        if(e>=3) {
                objetivo.setPs(objetivo.getPs()-danioBase);
                System.out.println(this.getNombreCarta()+ " ataca\n"+"causa "+ (danioBase)+" de daño a "+objetivo.getNombreCarta()+"\nVida actual de "+objetivo.getNombreCarta()+" es "+
                (objetivo.getPs() > 0 ? objetivo.getPs(): 0) );
            }else {
                System.out.println("No tiene suficiente energia para atacar");
                return;
            }
        }
    }

