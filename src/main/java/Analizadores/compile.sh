#!/bin/bash
echo "STARTING JFLEX COMPILING"
java -jar ~/Descargas/jflex-1.9.1/bin/jflex-full-1.9.1.jar -d ../../../java/Analizadores/AnalizadorLexico.jflex

echo "STARTING CUP COMPILING"
java -jar ~/Descargas/java-cup-bin-11b-20160615/java-cup-11b.jar -parser Sintactico GramaticaCup.cup
mv Sintactico.java ../../../java/Analizadores/Sintactico.java
mv sym.java ../../../java/Analizadores/sym.java