package logica.pokemones.Evo;

import logica.Ataque;
import logica.TipoCarta;
import logica.TipoElementos;

public class Blastoise extends Fase2 {
    public Blastoise() {
        super("Blastoise", TipoCarta.POKEMON, TipoElementos.AGUA, 150, false, false, true);
        evolucionaDe = "Wartortle";
        ataques.add(new Ataque("Hidrobomba", 3, 100));
    }
}
