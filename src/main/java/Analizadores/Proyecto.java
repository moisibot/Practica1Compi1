/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analizadores;

import java.util.List;



/**
 *
 * @author moisibot
 */
public class Proyecto {
    private String nombre;
    private List<Archivo> archivos;
    private List<Carpeta> carpetas;

    public Proyecto(String nombre, List<Archivo> archivos, List<Carpeta> carpetas) {
        this.nombre = nombre;
        this.archivos = archivos;
        this.carpetas = carpetas;
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

    public List<Carpeta> getCarpetas() {
        return carpetas;
    }

    public void setCarpetas(List<Carpeta> carpetas) {
        this.carpetas = carpetas;
    }

  

    
}
