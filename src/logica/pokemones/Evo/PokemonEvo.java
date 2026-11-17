package logica.pokemones.Evo;
import logica.TipoCarta;
import logica.TipoElementos;
import logica.pokemones.*;

public abstract class PokemonEvo extends Pokemon {

    PokemonEvo(String nombre, TipoCarta tipoCarta, TipoElementos tipo, int ps, boolean isEX, boolean isActive, boolean isEvo)
    {super(nombre, tipoCarta, tipo, ps, isEX, isActive, isEvo);{

    }}
    protected String evolucionaDe;
    public boolean validarEvo(Pokemon objetivo) {
    return objetivo != null && objetivo.getNombreCarta().equals(evolucionaDe);
}
public abstract boolean puedeEvolucionarSobre(Pokemon objetivo);
public String getEvolucionaDe(){
    return evolucionaDe;

}



    
}
