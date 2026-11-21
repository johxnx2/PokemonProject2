package logica.pokemones;

import logica.Ataque;
import logica.TipoElementos;
import logica.TipoCarta;

public class Zapdos extends Pokemon {
    public Zapdos () {
        super("Zapdos", TipoCarta.POKEMON, 
        TipoElementos.ELECTRICO, 130,true, false, false);
        ataques.add(new Ataque("Picotazo", 2, 30));
        ataques.add(new Ataque("Tormenta Electrica", 3, 90, TipoElementos.AGUA, 20));
    }
}

