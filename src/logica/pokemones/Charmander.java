package logica.pokemones;
import logica.Ataque;
import logica.TipoElementos;
import logica.TipoCarta;

public class Charmander extends Pokemon {
    public Charmander() 
    {super("Charmander", TipoCarta.POKEMON, TipoElementos.FUEGO, 60, false, false, true);
    ataques.add(new Ataque("Ascuas", 2, 30, TipoElementos.AGUA, 20));};
}