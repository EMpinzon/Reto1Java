/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaedgarpinzon;


public class Revista extends Recurso {
    
    private int numero ;
    private TipoRevista tipoRevista;
    
    public Revista(String titulo, boolean disponible, int numero , TipoRevista tipoRevista) {
        super(titulo, disponible);
        this.numero = numero;
        this.tipoRevista = tipoRevista;
    }

    public int getNumero() {
        return numero;
    }

    public TipoRevista getTipoRevista() {
        return tipoRevista;
    }
    
    
    @Override
    public String toString() {
        return "revista con el titulo de  " + this.getTitulo() + " con el numero de : "+this.numero+ " cuyo t"
                + "ipo de revista es de "+ tipoRevista.getTitulo() +   ( this.isDisponible()  ? " la revista "
                +  "esta disponible " : " la revista no esta disponilbe "  );    
    }

    
}
