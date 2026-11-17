package logica.pokemones.Evo;

import logica.TipoCarta;
import logica.TipoElementos;
import logica.pokemones.Pokemon;

public abstract class Fase1 extends PokemonEvo {
    Fase1(String nombre, TipoCarta tipoCarta, TipoElementos tipo, int ps, boolean isEX, boolean isActive, boolean isEvo)
    {super(nombre, tipoCarta, tipo, ps, isEX, isActive, isEvo);

    }
    @Override 
    public boolean puedeEvolucionarSobre(Pokemon objetivo) {
    return !(objetivo instanceof PokemonEvo) && validarEvo(objetivo);
}
    


}
