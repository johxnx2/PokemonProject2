package logica.pokemones;

import logica.Ataque;
import logica.TipoElementos;
import logica.TipoCarta;

public class Moltres extends Pokemon {
    public Moltres () {
        super("Moltres", TipoCarta.POKEMON, 
        TipoElementos.FUEGO, 130,  true, false, false);
        ataques.add(new Ataque("Aleteo", 1, 30, TipoElementos.AGUA, 20));
        ataques.add(new Ataque("Danza Infernal", 3, 70, TipoElementos.AGUA, 20));
    } 
}

