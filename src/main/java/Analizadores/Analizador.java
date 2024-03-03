package Analizadores;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java_cup.runtime.Scanner;

public class Analizador {
    private AnalizadorLexico lexico;
    private Sintactico sintactico;
   
   //excepcion para abrir el archivo
public Analizador() throws FileNotFoundException {
    this.lexico = new AnalizadorLexico(new FileReader("archivo.cvs")); 
    this.sintactico = new Sintactico((Scanner) lexico);
  }

  public void analizar() {
    try {
        //parse analiza el texto y la hace objeto
     sintactico.parse();
      //ejecutar logica del sql en los archvoos cvs
      System.out.println("Análisis realizado con éxito");
    } catch (Exception e) {
      //manejar error sintactico  
      System.out.println("Error de análisis: " + e.getMessage());
    }
  }

}
