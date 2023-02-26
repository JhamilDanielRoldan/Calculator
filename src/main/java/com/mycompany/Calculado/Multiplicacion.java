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
class Multiplicacion extends Operador {

    ArrayList<Division> divisiones;
    ArrayList<Potenciacion> potenciaciones;

    public Multiplicacion(String entrada) {
        super(entrada);
        divisiones = new ArrayList<>();
        potenciaciones=new ArrayList<>();
        if (entrada.contains("/")) {
            Operacion.operar(entrada, (ArrayList<Operador>) (Object) divisiones, "/", new Division(""));
        }
        else if(entrada.contains("^")){
            Operacion.operar(entrada, (ArrayList<Operador>) (Object) potenciaciones, "\\^", new Potenciacion("")); 
        }

    }

    @Override
    public Operador opera(String entrada) {
        // TODO: Implement this method
        return new Multiplicacion(entrada);
    }

    @Override
    public double resultado() {

        if (!divisiones.isEmpty()) {
            return Operacion.dividir(divisiones);
        } else if(!potenciaciones.isEmpty()){
            return Operacion.potenciar(potenciaciones);
        }
        else {
            return super.result;
        }
    }

    @Override
    public String toString() {
        if (!divisiones.isEmpty()) {
            return "division:" + divisiones.toString();
        } else if (!potenciaciones.isEmpty()) {
            return "potenciasion:" + potenciaciones.toString();
        } else {
            return super.toString();
        }
    }

}
