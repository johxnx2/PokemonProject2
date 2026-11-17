package logica.pokemones.Evo;

import logica.Ataque;
import logica.TipoCarta;
import logica.TipoElementos;

public class Gyarados extends Fase1 {
    public Gyarados() {
        super("Gyarados", TipoCarta.POKEMON, TipoElementos.AGUA, 150, false, false, true);
        evolucionaDe = "Magikarp";

        costoRetirada = 4;
        ataques.add(new Ataque("Hiperrayo", 4, 100));
    }
}
