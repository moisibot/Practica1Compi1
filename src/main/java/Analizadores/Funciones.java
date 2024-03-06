
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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Funciones {

    public void analizarLexico(String expr) throws IOException {
        int cont = 1;
        AnalizadorLexico lexer = new AnalizadorLexico(new StringReader(expr));
        StringBuilder resultado = new StringBuilder("LINEA" + cont + "\t\tSIMBOLO\n");

        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                ControladorLexico.setText(resultado.toString());
                return;
            }

            cont++;
            resultado.append(getTokenString(token, lexer.lexema));
        }
    }

    private String getTokenString(Tokens token, String lexema) {
        switch (token) {
            case Linea:
                return "Linea" + "\n";
            case SELECCIONAR:
            case EN:
            case FILTRAR:
            case INSERTAR:
            case ASIGNAR:
            case ELIMINAR:
            case ACTUALIZAR:
            case IGUAL:
            case MENOR:
            case MAYOR:
            case MENORIGUAL:
            case MAYORIGUAL:
            case DIFERENTE:
            case AND:
            case OR:
            case IDENTIFICADOR:
            case NUMERO:
            case CADENA:
            case PUNTOCOMA:
            case COMA:
            case PARENTESISABIERTO:
            case PARENTESISCERRADO:
                return "<" + token + ">\t" + lexema + "\n";
            default:
                return "  < " + lexema + "\n";
        }
    }

    public void analizar() {
        try {
            String expr = Editable.getText();
            analizarLexico(expr);
        } catch (IOException es) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, es);
        }
    }

   public void AnalizadorSintactico() throws Exception {
    String entrada = Editable.getText();
    Sintactico s = new Sintactico(new Analizadores.LexicoSintac(new StringReader(entrada)));

    try {
        s.parse();
        ControladorSintactico.setText("Análisis correcto");
        ControladorSintactico.setForeground(new Color(26, 111, 61));
    } catch (ParseException ex) {
        // Manejo de errores de análisis sintáctico
        Symbol sym = s.getS();
        int linea = sym.right + 1;
        int columna = sym.left + 1;
        String texto = sym.value.toString();
        
        // Actualizar el JLabel para mostrar el error
        String mensajeError = "Error de Sintaxis. Línea: " + linea + ", Columna: " + columna + ", Texto: \"" + texto + "\"";
        ControladorSintactico.setText(mensajeError);
        ControladorSintactico.setForeground(Color.red);
    }
}
}

