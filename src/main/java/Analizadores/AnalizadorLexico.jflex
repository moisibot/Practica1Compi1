package Analizadores;

import static codigo.Tokens.*;

%%

%class AnalizadorLexico
%type Tokens
%line 
%column
%{
   // Cadena para almacenar el texto del token
   public String lexema;
%}

%%

/* Definición de Tokens */
"SELECCIONAR"   { lexema = yytext(); return SELECCIONAR; }
"EN"            { lexema = yytext(); return EN; }
"FILTRAR"       { lexema = yytext(); return FILTRAR; }
"INSERTAR"      { lexema = yytext(); return INSERTAR; }  
"ASIGNAR"       { lexema = yytext(); return ASIGNAR; }
"ELIMINAR"      { lexema = yytext(); return ELIMINAR; }
"ACTUALIZAR"    { lexema = yytext(); return ACTUALIZAR; }

"="             { lexema = yytext(); return IGUAL; }
"<"             { lexema = yytext(); return MENOR; }
">"             { lexema = yytext(); return MAYOR; }
"<="            { lexema = yytext(); return MENORIGUAL; }
">="            { lexema = yytext(); return MAYORIGUAL }
"<>"            { lexema = yytext(); return DIFERENTE; }

"AND"           { lexema = yytext(); return AND; }
"OR"            { lexema = yytext(); return OR; }

[A-Za-z]+[A-Za-z0-9_]* { lexema = yytext(); return IDENTIFICADOR; }

[0-9]+          { lexema = yytext(); return NUMERO; }
\"[^\"]*\"      { lexema = yytext(); return CADENA; }

[ \t\n\r\f]+    { /* Ignorar espacios en blanco */ }
"//" .*         { /* Ignorar comentarios de una línea */ }
"/*" [^*]* "*" ~"*/"  { /* Ignorar comentarios de varias líneas */ }

";"             { lexema = yytext(); return PUNTOCOMA; }
","             { lexema = yytext(); return COMA; }
"("             { lexema = yytext(); return PARENTESISABIERTO; }
")"             { lexema = yytext(); return PARENTESISCERRADO; }