/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Carpetas;

import java.util.List;

/**
 *
 * @author moisibot
 */
public class Carpeta {
    private String nombre;
 private List<Archivo> archivos;
    public Carpeta(String nombre, List<Archivo> archivos) {
        this.nombre = nombre;
        this.archivos = archivos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<Archivo> archivos) {
        this.archivos = archivos;
    }
   
    
    
}
