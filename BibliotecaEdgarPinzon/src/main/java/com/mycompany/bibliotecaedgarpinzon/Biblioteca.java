/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaedgarpinzon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Biblioteca implements BibliotecaInterface {
    
    private List<Recurso> listaRecursos;

    public Biblioteca() {
        this.listaRecursos = new ArrayList<>();
    }

    @Override
    public void agregarRecurso( Recurso recurso ) {
        listaRecursos.add(recurso);
    }    
   
    
}
