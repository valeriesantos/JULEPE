import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class Mazo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mazo
{
    private ArrayList<Carta> mazo;
    private int cartaActual;

    private Random aleatorio;
    /**
     * Constructor for objects of class Mazo
     */
    public Mazo()
    {
        mazo = new ArrayList<Carta>();
        Random aleatorio = new Random();

        for( int paloActual = 0; paloActual < 4; paloActual++){
            for(int valorActual = 1; valorActual <= 12; valorActual++){
                if (valorActual != 8 && valorActual !=9){
                    mazo.add(new Carta(valorActual, paloActual));
                }

            }

        }

    }

    public void verCartasDelMazo()
    {
        for(int i = 0; i < mazo.size(); i++){
            System.out.println(mazo.get(i));

        }
    }

    public void barajarCartas(){
        for(int posicionActual = 0; posicionActual < mazo.size(); posicionActual++){
            Carta carta1 = mazo.get(posicionActual);
            Random aleatorio = new Random();
            int posicionAleatoria = aleatorio.nextInt(mazo.size());        
            mazo.set(posicionActual, mazo.get(posicionAleatoria));
            mazo.set(posicionAleatoria, carta1);
        }
    }

    public Carta sacarCarta(){
        Carta cartaADevolver = null;
        if(mazo.size() > 0)
        {
            cartaADevolver = mazo.get(0);
            mazo.remove(0);
        }

        return cartaADevolver;
    }
}

