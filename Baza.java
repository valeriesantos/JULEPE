import java.util.ArrayList;
/**
 * Write a description of class Baza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Baza
{
    private int numeroJugadoresATirarCarta;
    private int cartasEnBaza;
    private int jugadoresEnBaza;
    private Carta[] baza;

    /**
     * Constructor for objects of class Baza
     */
    public Baza(int numeroJugadoresATirarCarta, int paloQuePinta)
    {
        jugadoresEnBaza = numeroJugadoresATirarCarta;
        baza = new Carta[numeroJugadoresATirarCarta];
        cartasEnBaza = 0;

    }

    /**
     * Metodo que permite añadir las cartas tiradas a la baza
     */

    public void addCarta (Carta cartaQueTiraUnJugador, String nombreDelJugadorQueTira) {
        baza[cartasEnBaza] = cartaQueTiraUnJugador;
        cartasEnBaza++;
    }

    public int getPaloPrimeraCartaDeLaBaza(){
        int paloPrimeraCartaEnBaza = -1;

        if(baza[0] != null){
            baza[0].getPaloCarta();

        }
        return paloPrimeraCartaEnBaza;
    }
    
}

