package logica.pokemones;

import logica.Ataque;
import logica.TipoElementos;
import logica.TipoCarta;

public class Jigglypuff extends Pokemon {
    public Jigglypuff() {
        super("Jigglypuff", TipoCarta.POKEMON, 
        TipoElementos.INCOLORO, 70, false, false, false);
        ataques.add(new Ataque("Golpe", 1, 20));
    }
}
