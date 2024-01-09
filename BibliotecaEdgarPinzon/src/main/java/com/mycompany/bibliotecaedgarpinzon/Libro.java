/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaedgarpinzon;

/**
 *
 * @author user
 */
public class Libro extends Recurso {
    
    private String autor;

    public Libro(String titulo, boolean disponible , String autor) {
        super(titulo, disponible);
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "libro con el titulo de  " + this.getTitulo() + " escrito por :  " + this.autor +" "+  ( this.isDisponible()  ? " el "
                + "libro esta disponible " : " el libro no esta disponilbe "  );    
    }

    public String getAutor() {
        return autor;
    }
   
    
    
}
