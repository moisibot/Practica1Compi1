package Analizadores;

import java_cup.runtime.*;

%%

%class LexicoSintac
%type java_cup.runtime.Symbol
%public
%line 
%column
%cup
%unicode
%char

%{
  
   private Symbol symbol (int type){
        return new Symbol(type, yyline,yycolumn);
   }
   
   private Symbol symbol (int type, Object value){
        return new Symbol(type, yyline,yycolumn, value);
   }
%}

%%

"SELECCIONAR"   { return symbol(sym.SELECCIONAR); }
"EN"            { return symbol(sym.EN); }
"FILTRAR"       { return symbol(sym.FILTRAR); }
"INSERTAR"      { return symbol(sym.INSERTAR); }  
"ASIGNAR"       { return symbol(sym.ASIGNAR); }
"ELIMINAR"      { return symbol(sym.ELIMINAR); }
"ACTUALIZAR"    { return symbol(sym.ACTUALIZAR); }

"="             { return symbol(sym.IGUAL); }
"<"             { return symbol(sym.MENOR); }
">"             { return symbol(sym.MAYOR); }
"<="            { return symbol(sym.MENORIGUAL); }
">="            { return symbol(sym.MAYORIGUAL); }
"<>"            { return symbol(sym.DIFERENTE); }

"AND"           { return symbol(sym.AND); }
"OR"            { return symbol(sym.OR); }

[A-Za-z]+[A-Za-z0-9_]* { return symbol(sym.IDENTIFICADOR); }

[0-9]+          { return symbol(sym.NUMERO); }
\"[^\"]*\"      { return symbol(sym.CADENA); }

[ \t\n\r\f]+    { /* Ignorar espacios en blanco */ }
"//" .*         { /* Ignorar comentarios de una línea */ }
"/*" [^*]* "*" ~"*/"  { /* Ignorar comentarios de varias líneas */ }

";"             { return symbol(sym.PUNTOCOMA); }
","             { return symbol(sym.COMA); }
"("             { return symbol(sym.PARENTESISABIERTO); }
")"             { return symbol(sym.PARENTESISCERRADO); }

.               { /* Manejar caracteres no reconocidos */ }
