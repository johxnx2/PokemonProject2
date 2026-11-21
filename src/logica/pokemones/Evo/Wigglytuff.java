package logica.pokemones.Evo;

import logica.Ataque;
import logica.TipoCarta;
import logica.TipoElementos;

public class Wigglytuff extends Fase1 {
    public Wigglytuff() {
        super("Wigglytuff", TipoCarta.POKEMON, TipoElementos.INCOLORO, 110, false, false, true);
        evolucionaDe = "Jigglypuff";

        costoRetirada = 2;
        ataques.add(new Ataque("Bofetón", 2, 50));
    }
}
