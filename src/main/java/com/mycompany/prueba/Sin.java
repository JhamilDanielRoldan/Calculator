/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba;

import java.util.ArrayList;

/**
 *
 * @author jhamildanielrl
 */
public class Sin extends Funcion{
public Sin(String entrada){
    super(entrada);
}

    @Override
    protected double operador(double resultado) {
        return Math.sin(resultado);
    }

}
