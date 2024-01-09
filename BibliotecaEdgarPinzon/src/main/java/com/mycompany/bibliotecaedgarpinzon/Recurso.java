/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaedgarpinzon;

/**
 *
 * @author user
 */
public abstract class Recurso {
    
    protected int contadorId = 1 ;
    
    private int id;
    private String titulo;
    private boolean disponible;

    public Recurso(String titulo, boolean disponible) {
        contadorId =  contadorId +1;
        this.id = contadorId ;
        this.titulo = titulo;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }
            
    
    
    
    
    
}
