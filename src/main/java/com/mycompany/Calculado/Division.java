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
class Division extends Operador {

    ArrayList<Multiplicacion> multiplicaciones;
    ArrayList<Potenciacion> potenciaciones;
    public Division(String entrada) {
        super(entrada);
        multiplicaciones = new ArrayList<>();
        potenciaciones=new ArrayList<>();
        if (entrada.contains("*")) {
            Operacion.operar(entrada, (ArrayList<Operador>) (Object) multiplicaciones, "\\*", new Multiplicacion(""));
        }
        else if(entrada.contains("^")){
            Operacion.operar(entrada, (ArrayList<Operador>) (Object) potenciaciones, "\\^", new Potenciacion("")); 
        }
       // System.out.println(potenciaciones);
    }

    @Override
    public double resultado() {
        if (!multiplicaciones.isEmpty()) {
            //TODO puede que haya un error por esto beta
            return Operacion.multiplicar(multiplicaciones);
        } 
        else if(!potenciaciones.isEmpty()){
            return Operacion.potenciar(potenciaciones);
        } 
        else {
            return super.resultado();
        }
    }

   

    @Override
    public Operador opera(String entrada) {
        return new Division(entrada);
    }

    @Override
    public String toString() {
        if (!multiplicaciones.isEmpty()) {
            return "multiplicacion:" + multiplicaciones.toString();
        } else if (!potenciaciones.isEmpty()) {
            return "potenciasion:" + potenciaciones.toString();
        } else {
            return super.toString();
        }
    }

}
