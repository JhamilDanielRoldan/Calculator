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
class Division extends Operador {

    ArrayList<Operador> multiplicaciones;

    public Division(String entrada) {
        super(entrada);
        multiplicaciones = new ArrayList<>();
        if (entrada.contains("*")) {
            Operacion.operar(entrada, (ArrayList<Operador>) (Object) multiplicaciones, "\\*", new Multiplicacion(""));
        }

    }

    @Override
    public double resultado() {
        if (!multiplicaciones.isEmpty()) {
            return multiplicar();
        } else {
            return super.resultado();
        }
    }

    public double multiplicar() {
        double numero;
        numero = multiplicaciones.get(0).resultado();
        for (int n = 1; n < multiplicaciones.size(); n++) {
            numero *= multiplicaciones.get(n).resultado();
        }
        return numero;
    }

    @Override
    public Operador opera(String entrada) {
        // TODO: Implement this method
        return new Division(entrada);
    }

    @Override
    public String toString() {
        if (!multiplicaciones.isEmpty()) {
            return "multiplicacion:" + multiplicaciones.toString();
        } else {
            return super.toString();
        }
    }

}
