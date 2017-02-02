import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Carta[] cartasEnMano;
    private int numeroCartasEnMano;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String namePlayer)
    {
        nombre = namePlayer;
        cartasEnMano = new Carta[5];
        numeroCartasEnMano = 0;
    }

    /**
     * Metodo que hace que el jugador reciba una carta.
     */
    public void recibirCarta(Carta cartaRecibida){
        if(numeroCartasEnMano < 5){        
            cartasEnMano[numeroCartasEnMano] = cartaRecibida;
        }
        numeroCartasEnMano++;
    }

    /**
     * Metodo que muestra las cartas del jugador por pantalla     
     */
    public void verCartasJugador()
    {
        for(Carta cartaActual : cartasEnMano){ 
            if(cartaActual != null){
                System.out.println(cartaActual); 
            }
        }
    }

    public String getNombre(){
        return nombre;

    }

    /**
     * Metodo que devuelve la carta especificada como parametro si
     * el jugador dispone de ella y simula que se lanza a la mesa.
     */
    public Carta tirarCarta(String nombreCarta){
        Carta cartaTirada = null;
        if( numeroCartasEnMano > 0){

            int cartaActual = 0;
            boolean buscando = true;
            while(cartaActual < cartasEnMano.length && buscando){
                if(cartasEnMano[cartaActual] != null){
                    if(nombreCarta.equals(cartasEnMano[cartaActual].toString())){
                        buscando = false;
                        cartaTirada = cartasEnMano[cartaActual];
                        cartasEnMano[cartaActual] = null;
                        numeroCartasEnMano--;
                        System.out.println(nombre + " ha tirado " + cartaTirada);
                    }
                }
                cartaActual++;    
            }
        }
        return cartaTirada;
    }

    /**
     * Metodo que tira carta aleatoria
     */
    public Carta tirarCartaAleatoria()

    {
        Carta cartaTirada = null;
        if(numeroCartasEnMano > 0){
            Random aleatorio = new Random();
            boolean elJugadorHaTiradoCarta = false;

            while( elJugadorHaTiradoCarta == false){
                int posicionAleatoria = aleatorio.nextInt(5);

                if(cartasEnMano[posicionAleatoria] != null){
                    cartaTirada = cartasEnMano[posicionAleatoria];
                    cartasEnMano[posicionAleatoria] = null;
                    numeroCartasEnMano--;
                    System.out.println( nombre + " ha tirado " + cartaTirada);
                    elJugadorHaTiradoCarta = true;
                }
            }
        }
        return cartaTirada;
    }
}