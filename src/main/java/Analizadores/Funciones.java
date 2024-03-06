/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analizadores;

import Front.Interfaz;
import static Front.Interfaz.ControladorLexico;
import static Front.Interfaz.ControladorSintactico;
import static Front.Interfaz.Editable;
import static Front.Interfaz.Ingreso;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author SELVYN
 */
public class Funciones {
    
      public void analizarLexico() throws IOException {
        int cont = 1;

        // aque el lexico debe de quitar ese error al generar el AnalizadorLexico . java pero eso hay qye averugyar coomo agregar jar como dependencias 
        String expr = (String) Ingreso.getText();
        AnalizadorLexico lexer = new AnalizadorLexico(new StringReader(expr));
        String resultado = "LINEA" + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer. yylex() ;
            if (token == null) {
                ControladorLexico.setText(resultado);
                return;
            }
            switch (token) {
                // esto es la lista para conocer los diferentes tokens que se tienen
                case Linea:
                    cont++;
                    resultado += "Linea" + cont + "\n";
                case SELECCIONAR:
                    cont++;
                    resultado += "<SELECCIONAR>\t" + lexer.lexema + "\n";
                    break;
                case EN:
                    cont++;
                    resultado += "<EN>\t" + lexer.lexema + "\n";
                    break;
                case FILTRAR:
                    cont++;
                    resultado += "<FILTRAR>\t" + lexer.lexema + "\n";
                    break;
                case INSERTAR:
                    cont++;
                    resultado += "<INSERTAR>\t" + lexer.lexema + "\n";
                    break;
                case ASIGNAR:
                    cont++;
                    resultado += "<ASIGNAR>\t" + lexer.lexema + "\n";
                    break;
                case ELIMINAR:
                    cont++;
                    resultado += "<ELIMINAR>\t" + lexer.lexema + "\n";
                    break;
                case IGUAL:
                    cont++;
                    resultado += "<IGUAL>\t" + lexer.lexema + "\n";
                    break;
                case MENOR:
                    cont++;
                    resultado += "<MENOR>\t" + lexer.lexema + "\n";
                    break;
                case MAYOR:
                    cont++;
                    resultado += "<MAYOR>\t" + lexer.lexema + "\n";
                    break;
                case MENORIGUAL:
                    cont++;
                    resultado += "<MENORIGUAL>\t" + lexer.lexema + "\n";
                    break;
                case MAYORIGUAL:
                    cont++;
                    resultado += "<MAYORIGUAL>\t" + lexer.lexema + "\n";
                    break;
                case DIFERENTE:
                    cont++;
                    resultado += "<DIFERENTE>\t" + lexer.lexema + "\n";
                    break;
                case AND:
                    cont++;
                    resultado += "<AND>\t" + lexer.lexema + "\n";
                    break;
                case OR:
                    cont++;
                    resultado += "<OR>\t" + lexer.lexema + "\n";
                    break;
                case IDENTIFICADOR:
                    cont++;
                    resultado += "<IDENTIFICADOR>\t" + lexer.lexema + "\n";
                    break;
                case NUMERO:
                    cont++;
                    resultado += "<NUMERO>\t\t" + lexer.lexema + "\n";
                    break;
                case CADENA:
                    cont++;
                    resultado += "<CADENA>\t" + lexer.lexema + "\n";
                    break;
                case PUNTOCOMA:
                    cont++;
                    resultado += "<PUNTOCOMA>\t" + lexer.lexema + "\n";
                    break;
                case COMA:
                    cont++;
                    resultado += "<COMA>\t\t" + lexer.lexema + "\n";
                    break;
                case PARENTESISABIERTO:
                    cont++;
                    resultado += "<PARENTESISABIERTO>\t" + lexer.lexema + "\n";
                    break;
                case PARENTESISCERRADO:
                    cont++;
                    resultado += "<PARENTESISCERRADO>\t" + lexer.lexema + "\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexema + "\n";
                    break;
            }

        }

    }

    public void analizar() {
        try {
            analizarLexico();
        } catch (IOException es) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, es);
        }
    }

    public void AnalizadorSintactico() {
        String entrada = Editable.getText();
        //este error debera de desaparecer cuando ya se  compilado el sintax eso lo hace en generador
        Sintactico s = new Sintactico(new Analizadores.LexicoSintac(new StringReader(entrada)));

        try {
            s.parse();
            ControladorSintactico.setText("Analisis correctamente");
            ControladorSintactico.setForeground(new Color(26, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            ControladorSintactico.setText("Error de Sintaxis. Linea: " + (sym.right + 1) + "Columna: " + (sym.left + 1) + ", texto: \"" + sym.value + "\"");
            ControladorSintactico.setForeground(Color.red);
        }

    }

}
