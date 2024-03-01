package Front;

import Analizadores.Analizador;
import java.io.FileNotFoundException;


/**
 *
 * @author moisibot
 */
public class Practica1compi1 {

    public static void main(String[] args) throws FileNotFoundException  {
       Interfaz ide = new Interfaz();
        ide.setVisible(true);
        
Analizador analizador = new Analizador();
    analizador.analizar(); 
    }
}
