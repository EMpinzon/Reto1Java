/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bibliotecaedgarpinzon;

import java.util.List;

/**
 *
 * @author user
 */
public interface BibliotecaInterface {
    
    public abstract void agregarRecurso( Recurso recurso);
    public abstract void prestarRecurso(int num);
    public abstract List<Recurso> buscarRecursoPorTitulo(String titulo);
    
    
    
}
