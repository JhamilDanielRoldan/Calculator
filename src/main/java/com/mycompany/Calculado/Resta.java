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
class Resta extends Operador {

    ArrayList<Multiplicacion> multiplicaciones;
    ArrayList<Division> divisiones;
    ArrayList<Potenciacion> potenciaciones;

    public Resta(String entrada) {
        super(entrada);
        multiplicaciones = new ArrayList<>();
        divisiones = new ArrayList<>();
        potenciaciones=new ArrayList<>();
        if (entrada.contains("*")) {
            Operacion.operar(entrada, (ArrayList<Operador>) (Object) multiplicaciones, "\\*", new Multiplicacion(""));
        } else if (entrada.contains("/")) {
            Operacion.operar(entrada, (ArrayList<Operador>) (Object) divisiones, "/", new Division(""));

        } else if (entrada.contains("^")) {
            Operacion.operar(entrada, (ArrayList<Operador>) (Object) potenciaciones, "\\^", new Potenciacion(""));
        }
    }

    @Override
    public Operador opera(String entrada) {
        // TODO: Implement this method
        return new Resta(entrada);
    }

    @Override
    public double resultado() {

        if (!multiplicaciones.isEmpty()) {
            return Operacion.multiplicar(multiplicaciones);
        } else if (!divisiones.isEmpty()) {
            return Operacion.dividir(divisiones);
        }else if(!potenciaciones.isEmpty()){
            return Operacion.potenciar(potenciaciones);
        }
        else {
            return super.result;
        }
    }

    @Override
    public String toString() {
        if (!multiplicaciones.isEmpty()) {
            return "multiplicacion:" + multiplicaciones.toString();
        } else if (!divisiones.isEmpty()) {
            return "division:" + divisiones.toString();
        }else if (!potenciaciones.isEmpty()) {
            return "potenciasion:" + potenciaciones.toString();
        }  
        else {
            return super.toString();
        }
    }

}
