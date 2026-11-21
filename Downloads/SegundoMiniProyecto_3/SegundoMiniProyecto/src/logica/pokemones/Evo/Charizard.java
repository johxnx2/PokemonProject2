package logica.pokemones.Evo;

import logica.Ataque;
import logica.TipoCarta;
import logica.TipoElementos;

public class Charizard extends Fase2 {
    public Charizard() {
        super("Charizard", TipoCarta.POKEMON, TipoElementos.FUEGO, 150, false, false, true);
        evolucionaDe = "Charmeleon";
        costoRetirada = 2;
        ataques.add(new Ataque("Giro Fuego", 4, 120));
    }
}
