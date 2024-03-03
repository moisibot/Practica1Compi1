package Analizadores;

import java_cup.runtime.*;

// opciones y declaraciones
%%

%class AnalizadorLexico
%public
%line 
%column
%cup
%unicode

%{
  
    private Symbol symbol(int type, String lexema) {
        return new Symbol(type, new Token(lexema, yyline + 1, yycolumn + 1));
    }
%}



%%

"SELECCIONAR"   { return symbol(sym.SELECCIONAR,yytext()); }
"EN"            { return symbol(sym.EN,yytext()); }
"FILTRAR"       { return symbol(sym.FILTRAR,yytext()); }
"INSERTAR"      { return symbol(sym.INSERTAR,yytext()); }  
"ASIGNAR"       { return symbol(sym.ASIGNAR,yytext()); }
"ELIMINAR"      { return symbol(sym.ELIMINAR,yytext()); }

"="             { return symbol(sym.IGUAL,yytext()); }
"<"             { return symbol(sym.MENOR,yytext()); }
">"             { return symbol(sym.MAYOR,yytext()); }
"<="            { return symbol(sym.MENORIGUAL,yytext()); }
">="            { return symbol(sym.MAYORIGUAL,yytext()); }
"<>"            { return symbol(sym.DIFERENTE,yytext()); }

"AND"           { return symbol(sym.AND,yytext()); }
"OR"            { return symbol(sym.OR,yytext()); }

[A-Za-z]+[A-Za-z0-9_]* { return symbol(sym.IDENTIFICADOR,yytext()); }


[0-9]+          { return symbol(sym.NUMERO,yytext()); }
\"[^\"]*\"      { return symbol(sym.CADENA,yytext()); }

[ \t\n\r\f]+    { /* Ignorar espacios en blanco */ }
"//" .*         { /* Ignorar comentarios de una línea */ }
"/*" [^*]* "*" ~"*/"  { /* Ignorar comentarios de varias líneas */ }

";"             { return symbol(sym.PUNTOCOMA,yytext()); }
","             { return symbol(sym.COMA,yytext()); }
"("             { return symbol(sym.PARENTESISABIERTO,yytext()); }
")"             { return symbol(sym.PARENTESISCERRADO,yytext()); }

[^] {}