/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba;

/**
 *
 * @author jhamildanielrl
 */
public class Cos extends Funcion{
    
    public Cos(String entrada) {
        super(entrada);
    }

    @Override
    protected double operador(double resultado) {
       return Math.cos(resultado);
    }
    
}
