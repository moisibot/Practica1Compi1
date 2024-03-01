package Analizadores;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java_cup.runtime.Scanner;

public class Analizador {
    private AnalizadorLexico lexico;
   private Sintactico sintactico;
public Analizador() throws FileNotFoundException {
    this.lexico = new AnalizadorLexico(new FileReader("archivo.cvs")); 
    this.sintactico = new Sintactico((Scanner) lexico);
  }

  public void analizar() {
    try {
     sintactico.parse();
      //ejecutar lógica de consultas SQL sobre CSV
      System.out.println("Análisis realizado con éxito");
    } catch (Exception e) {
      //manejar error sintáctico  
      System.out.println("Error de análisis: " + e.getMessage());
    }
  }

}
