package logica.pokemones;
import logica.Ataque;
import logica.TipoElementos;
import logica.TipoCarta;


public class Mewtwo extends Pokemon {
    public Mewtwo() {super("Mewtwo", 
    TipoCarta.POKEMON, TipoElementos.PSIQUICO, 150, true, false, false);
    ataques.add(new Ataque("Ataque Psíquico", 2, 50, TipoElementos.INCOLORO, 20));
    ataques.add(new Ataque("Psicorrayo", 3, 150, TipoElementos.INCOLORO, 20));}
}
