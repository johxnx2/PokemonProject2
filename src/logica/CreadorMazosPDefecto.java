package logica;

import java.util.ArrayList;
import java.util.function.Supplier;
import logica.CartasEntrenador.*;
import logica.pokemones.*;
import logica.pokemones.Evo.*;



public class CreadorMazosPDefecto {
    

private static void agregar(ArrayList<Carta> mazo, Supplier<Carta> carta, int copias) {
    for (int i = 0; i < copias; i++) {
        mazo.add(carta.get());  
    }
}

public static ArrayList<Carta> mazoAgua() {
    ArrayList<Carta> mazo = new ArrayList<>();
    agregar(mazo, Squirtle::new, 2);
    agregar(mazo, Magikarp::new, 2);
    agregar(mazo, Articuno::new, 2);
    agregar(mazo, Wartortle::new, 2);
    agregar(mazo, Blastoise::new, 2);
    agregar(mazo, Gyarados::new, 2);
    agregar(mazo, Misty::new, 2);
    agregar(mazo, Pokebola::new, 2);
    agregar(mazo, Pocion::new, 2);
    agregar(mazo, TurboVelocidad::new, 2);
    return mazo;
}

public static ArrayList<Carta> mazoFuego() {
    ArrayList<Carta> mazo = new ArrayList<>();
    agregar(mazo, Charmander::new, 2);
    agregar(mazo, Moltres::new, 2);
    agregar(mazo, Jigglypuff::new, 2);
    agregar(mazo, Snorlax::new, 2);
    agregar(mazo, Charmeleon::new, 2);
    agregar(mazo, Charizard::new, 2);
    agregar(mazo, Wigglytuff::new, 2);
    agregar(mazo, Pokebola::new, 2);
    agregar(mazo, Pocion::new, 2);
    agregar(mazo, TurboVelocidad::new, 2);
    return mazo;
}

public static ArrayList<Carta> mazoRayo() {
    ArrayList<Carta> mazo = new ArrayList<>();
    agregar(mazo, PokPikachu::new, 2);
    agregar(mazo, Zapdos::new, 2);
    agregar(mazo, Mewtwo::new, 2);
    agregar(mazo, Jigglypuff::new, 2);
    agregar(mazo, Raichu::new, 2);
    agregar(mazo, Wigglytuff::new, 2);
    agregar(mazo, Pokebola::new, 2);
    agregar(mazo, Pocion::new, 2);
    agregar(mazo, TurboVelocidad::new, 2);
    agregar(mazo, InvestProfe::new, 2);
    return mazo;
}
public static void mostrarMazos(ArrayList<Carta> mazo1, ArrayList<Carta> mazo2, ArrayList<Carta> mazo3) {
    System.out.println("----------------------------------------------------");
    System.out.printf("%-15s %-15s %-15s%n", "Mazo Agua", "Mazo Fuego", "Mazo Rayo");
    for (int i = 0; i < mazo1.size(); i++) {
        System.out.printf("%-15s %-15s %-15s%n",
                mazo1.get(i).getNombreCarta(),
                mazo2.get(i).getNombreCarta(),
                mazo3.get(i).getNombreCarta());
    }
    System.out.println("----------------------------------------------------");
}


}