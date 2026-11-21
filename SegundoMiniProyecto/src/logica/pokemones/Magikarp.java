package logica.pokemones;

import logica.Ataque;
import logica.TipoElementos;
import logica.TipoCarta;

public class Magikarp extends Pokemon {
    public Magikarp () {
        super("Magikarp", TipoCarta.POKEMON, 
        TipoElementos.AGUA, 30, false, false, true);
        ataques.add(new Ataque("Golpe", 2, 10, TipoElementos.FUEGO, 20));
    }
}
