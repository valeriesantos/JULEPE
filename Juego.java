import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Juego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Juego
{
    // instance variables - replace the example below with your own
    private Jugador[] jugadores;
    private Mazo mazo;
    private int paloQuePinta;

    /**
     * Constructor for objects of class Juego
     */
    public Juego(int numeroJugadores,String jugadorReal)
    {

        mazo = new Mazo();
        jugadores = new Jugador[numeroJugadores];
        ArrayList<String> posiblesNombres = new ArrayList<String>();
        posiblesNombres.add("Valerie");
        posiblesNombres.add("Cristian");
        posiblesNombres.add("Sonia");
        posiblesNombres.add("Noe");
        posiblesNombres.add("Oscar");
        posiblesNombres.add("Carmen");
        posiblesNombres.add("Ruben");
        posiblesNombres.add("Jonatan");
        
        Jugador jugadorHumano = new Jugador(jugadorReal);
        jugadores[0] = jugadorHumano;

        Random aleatorio = new Random();
        for(int i = 0; i < numeroJugadores; i++){
            int posicionNombreElegido = aleatorio.nextInt(posiblesNombres.size());
            String nombreAleatorioElegido = posiblesNombres.get(posicionNombreElegido);
            posiblesNombres.remove(posicionNombreElegido);

            Jugador jugador = new Jugador( nombreAleatorioElegido);
            jugadores[i] = jugador;
             System.out.println("Bienvenido a la partida " + "  "+ jugadorReal);
       }

       System.out.println("Tus rivales son: ");
       
    }


    public void repartirCartas()
    {
        mazo.barajarCartas();
        Carta cartaARepartir = null;
        for (int cartasARepartir = 0; cartasARepartir < 5; cartasARepartir++)
        {           
            for (int jugadorActual = 0; jugadorActual < jugadores.length; jugadorActual++)
            {
                cartaARepartir = mazo.sacarCarta();
                jugadores[jugadorActual].recibirCarta(cartaARepartir);
            }  
        }  
        paloQuePinta = cartaARepartir.getPaloCarta();
    }

    public void verCartasJugador(String nombreJugador)
    {
        int jugadorActual = 0;
        boolean buscando = true ;
        while (jugadorActual < jugadores.length && buscando){
            if (nombreJugador.equals(jugadores[jugadorActual].getNombre())){
                jugadores[jugadorActual].verCartasJugador();
                buscando = false;

            }
            jugadorActual++;
        }
    }
}
