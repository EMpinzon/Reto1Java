/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.bibliotecaedgarpinzon;

/**
 *
 * @author user
 */
public enum TipoRevista {
    
    CIENCIA(4454,"ciencia"),DEPORTES(7889,"deportes"),FARANDULA(48216,"farandula"),HISTORIA(78434,"historia"), FILOSOFIA(7456,"filosofia");
    
    private int codigo;
    private String titulo;

    private TipoRevista(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }
    
}
