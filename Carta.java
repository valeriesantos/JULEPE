import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Carta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carta
{
    //Valor de la carta; de 1 a 7 y de 10 a 12
    private int valorCarta;
    //Valor del palo; 0 es oros, 1 es copas, 2 es espadas y 3 es bastos.
    private int paloCarta;
    private ArrayList<Carta> Carta;
    private int posicionEnEscala;

    /**
     * Constructor for objects of class Carta
     */
    public Carta(int valorCarta, int paloCarta)
    {
        this.valorCarta = valorCarta;
        this.paloCarta = paloCarta;

    }

    public int getValorCarta(){
        return valorCarta;
    }

    public int getPaloCarta(){
        return paloCarta;

    }

    public String toString(){
        String textoADevolverPalo= paloCarta + "";
        String textoADevolverTotal = "";
        String textoADevolverValor = Integer.toString(valorCarta);

        switch(paloCarta){
            case 0:
            textoADevolverPalo = "oros";
            break;
            case 1:
            textoADevolverPalo = "copas";
            break;
            case 2:
            textoADevolverPalo = "espadas";
            break;
            case 3:
            textoADevolverPalo = "bastos";
            break;
        }

        switch(valorCarta) {
            case 1:
            textoADevolverValor = "as";
            break;
            case 10:
            textoADevolverValor = "sota";
            break;
            case 11:
            textoADevolverValor = "caballo";
            break;
            case 12:
            textoADevolverValor = "rey";
            break;
        }

        textoADevolverTotal = textoADevolverValor + " de " + textoADevolverPalo;
        return textoADevolverTotal;
    }

    public int getPosicionEnEscala(){
        int posicion = valorCarta; 
        if(valorCarta == 3){
            posicion = 13;
        }
        else if(valorCarta ==1){
            posicion = 14;
        }
        return posicionEnEscala;
    }

    public boolean ganaA (Carta cartaAComparar, int paloQuePinta){
        boolean gana = false;
        if(this.paloCarta == cartaAComparar.getPaloCarta()){
            //En caso de que tengan el mismo palo...
            if( getPosicionEnEscala()  > cartaAComparar.getPosicionEnEscala()){
                gana = true;                
            }
        }
        else {
            //En caso de que tengan distinto palo...
            if(cartaAComparar.getPaloCarta() != paloQuePinta){
                gana = true;
            }
        }
        return gana;   
    }

}
