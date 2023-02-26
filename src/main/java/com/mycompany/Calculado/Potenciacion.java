/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Calculado;

/**
 *
 * @author jhamildanielrl
 */
public class Potenciacion extends Operador{
    
    public Potenciacion(String entrada) {
        super(entrada);
    }
     @Override
    public Operador opera(String entrada) {
        return new Potenciacion(entrada);
    }
    
}
