package logica.pokemones;
import logica.Ataque;
import logica.TipoElementos;
import logica.TipoCarta;

public class Squirtle extends Pokemon {
    public Squirtle() {

        super("Squirtle", TipoCarta.POKEMON, TipoElementos.AGUA, 60, false, false, true);
        ataques.add(new Ataque("Placaje", 1, 20, TipoElementos.FUEGO, 20));}}
