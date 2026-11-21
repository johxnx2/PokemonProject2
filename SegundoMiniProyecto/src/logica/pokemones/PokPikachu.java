//AL CREAR LA CLASE PIKACHU SE PONE AUTOMÁTICAMENTE EN MINÚSCULA ASÍ SE CREE VARIAS VECES
package logica.pokemones;
import logica.Ataque;
import logica.TipoElementos;
import logica.TipoCarta;

public class PokPikachu extends Pokemon {
    public PokPikachu() {super("Pikachu", TipoCarta.POKEMON, TipoElementos.ELECTRICO, 60,  false, false, true);
    ataques.add(new Ataque("Mordisco", 1, 20, TipoElementos.AGUA, 20));}
}
