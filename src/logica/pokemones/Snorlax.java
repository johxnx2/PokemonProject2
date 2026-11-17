package logica.pokemones;
import logica.Ataque;
import logica.pokemones.Pokemon;
import logica.TipoElementos;
import logica.TipoCarta;

public class Snorlax extends Pokemon {
    public Snorlax () {
        super("Snorlax", TipoCarta.POKEMON, 
        TipoElementos.INCOLORO, 150,  false, false, false);
        ataques.add(new Ataque("Golpe Cuerpo", 3, 100));}
    }



