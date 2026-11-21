package logica.pokemones.Evo;

import logica.Ataque;
import logica.TipoCarta;
import logica.TipoElementos;

public class Wartortle extends Fase1 {
    public Wartortle() {
        super("Wartortle", TipoCarta.POKEMON, TipoElementos.AGUA, 80, false, false, true);
        evolucionaDe = "Squirtle";
        ataques.add(new Ataque("Salpicadura", 2, 40));
    }
}
