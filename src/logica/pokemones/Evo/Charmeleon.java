package logica.pokemones.Evo;
import logica.Ataque;
import logica.TipoCarta;
import logica.TipoElementos;

public class Charmeleon extends Fase1 {
    public Charmeleon() {
        super("Charmeleon", TipoCarta.POKEMON, TipoElementos.FUEGO, 90, false, false, true);
        evolucionaDe = "Charmander";
        ataques.add(new Ataque("Garra Ígnea", 2, 50));
    }
}
