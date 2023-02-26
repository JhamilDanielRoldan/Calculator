/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Calculado;

import java.util.ArrayList;

/**
 *
 * @author jhamildanielrl
 */
public class Calculator {

    public static void main(String[] args) {
        String entrada = "cos(5^(9*9+8/-cos(9)))+(8+9)";
        System.out.println(resul(entrada));
            
    }
    public static double resul(String entrada){
        double resulta;
        String salida=new Funcion(entrada).resultado();
        resulta=resultado(salida);
        System.out.println("INFO:Resultado:"+resulta);
        return resulta;
    }
   private static double resultado(String entrada){
        Operando resulta=new Operando(entrada);
        System.out.println("INFO:Calculando:"+resulta);
       return resulta.resultado();
    }
    
}


