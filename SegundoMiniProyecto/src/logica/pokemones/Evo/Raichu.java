package logica.pokemones.Evo;

import logica.Ataque;
import logica.TipoElementos;
import logica.TipoCarta;

public class Raichu extends Fase1 {
    public Raichu() {
        super("Raichu", TipoCarta.POKEMON, TipoElementos.ELECTRICO, 100, false, false, true);
        evolucionaDe = "Pikachu";
        ataques.add(new Ataque("Trueno", 2, 60));
    }
}
