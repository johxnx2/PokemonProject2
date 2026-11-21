package logica.pokemones;

import logica.Ataque;
import logica.TipoElementos;
import logica.TipoCarta;

public class Articuno extends Pokemon {
    public Articuno() {
        super("Articuno", TipoCarta.POKEMON,
                TipoElementos.AGUA, 130, true, false, false);
        ataques.add(new Ataque("Viento Helado", 1, 30, TipoElementos.FUEGO, 20));
        ataques.add(new Ataque("Ventisca", 3, 100, TipoElementos.FUEGO, 20));
    }
}
