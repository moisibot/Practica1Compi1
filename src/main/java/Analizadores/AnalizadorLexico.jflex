package Analizadores;
import java_cup.runtime.*;

//opciones y declaraciones
%%

%class AnalizadorLexico
%type Symbol

%{
public enum Symbol {
    SELECCIONAR, EN, FILTRAR, INSERTAR, ACTUALIZAR, ASIGNAR, ELIMINAR,
    IGUAL, MENOR, MAYOR, MENORIGUAL, MAYORIGUAL, DIFERENTE,
    AND, OR,
    IDENTIFICADOR, CADENA,
    PUNTOCOMA, COMA, PARENTESISABIERTO, PARENTESISCERRADO,
    ERROR
}
%}

%%

"SELECCIONAR"   { return Symbol.SELECCIONAR; }
"EN"            { return Symbol.EN; }
"FILTRAR"       { return Symbol.FILTRAR; }
"INSERTAR"      { return Symbol.INSERTAR; }  
"ASIGNAR"       { return Symbol.ASIGNAR; }
"ELIMINAR"      { return Symbol.ELIMINAR; }

"="             { return Symbol.IGUAL; }
"<"             { return Symbol.MENOR; }
">"             { return Symbol.MAYOR; }
"<="            { return Symbol.MENORIGUAL; }

">="            { return Symbol.MAYORIGUAL; }
"<>"            { return Symbol.DIFERENTE; }

"AND"           { return Symbol.AND; }
"OR"            { return Symbol.OR; }

[A-Za-z]+[A-Za-z0-9_]* { return Symbol.IDENTIFICADOR; }

\"[^\"]*\"      { return Symbol.CADENA; }

[ \t\n\r\f]+    { /* ignora espacios en blanco */ }
"//" .*         { /* ignora comentarios de una linea */ }
"/*" [^*]* "*" ~"*/" { /* ignora comentarios de varias lineas */ }

";"             { return Symbol.PUNTOCOMA; }
","             { return Symbol.COMA; }
"("             { return Symbol.PARENTESISABIERTO; }
")"             { return Symbol.PARENTESISCERRADO; }

.               { return Symbol.ERROR; }
