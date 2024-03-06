package Analizadores;
import java_cup.runtime.Symbol;


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
     
   private Symbol symbol (int type, Object value){
        return new Symbol(type, yyline,yycolumn, value);
   } 
  private Symbol symbol (int type){
        return new Symbol(type, yyline,yycolumn);
   }
%}

%%

"SELECCIONAR"   { return new Symbol(sym.SELECCIONAR,yychar, yyline, yytext()); }
"EN"            { return new Symbol(sym.EN,yychar, yyline,yytext()); }
"FILTRAR"       { return new Symbol(sym.FILTRAR,yychar, yyline,yytext()); }
"INSERTAR"      { return new Symbol(sym.INSERTAR,yychar, yyline,yytext()); }  
"ASIGNAR"       { return new Symbol(sym.ASIGNAR,yychar, yyline, yytext()); }
"ELIMINAR"      { return new Symbol(sym.ELIMINAR,yychar, yyline,yytext()); }

"="             { return new Symbol(sym.IGUAL,yychar, yyline, yytext()); }
"<"             { return new Symbol(sym.MENOR,yychar, yyline, yytext()); }
">"             { return new Symbol(sym.MAYOR,yychar, yyline, yytext()); }
"<="            { return new Symbol(sym.MENORIGUAL,yychar, yyline, yytext()); }
">="            { return new Symbol(sym.MAYORIGUAL,yychar, yyline, yytext()); }
"<>"            { return new Symbol(sym.DIFERENTE,yychar, yyline, yytext()); }

"AND"           { return new Symbol(sym.AND,yychar, yyline, yytext()); }
"OR"            { return new Symbol(sym.OR,yychar, yyline, yytext()); }

[A-Za-z]+[A-Za-z0-9_]* { return new Symbol(sym.IDENTIFICADOR,yychar, yyline, yytext()); }


[0-9]+          { return new Symbol(sym.NUMERO,yychar, yyline, yytext()); }
\"[^\"]*\"      { return new Symbol(sym.CADENA,yychar, yyline, yytext()); }

[ \t\n\r\f]+    { /* Ignorar espacios en blanco */ }
"//" .*         { /* Ignorar comentarios de una línea */ }
"/" [^]* "" ~"/"  { /* Ignorar comentarios de varias líneas */ }

";"             { return new Symbol(sym.PUNTOCOMA,yychar, yyline, yytext()); }
","             { return new Symbol(sym.COMA,yychar, yyline, yytext()); }
"("             { return new Symbol(sym.PARENTESISABIERTO,yychar, yyline, yytext()); }
")"             { return new Symbol(sym.PARENTESISCERRADO,yychar, yyline, yytext()); }

[^] {}