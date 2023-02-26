/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Calculado;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jhamildanielrl
 */
class Operando extends Operador {

    ArrayList<Suma> sumas;
    ArrayList<Resta> restas;
    ArrayList<Multiplicacion> multiplicaciones;
    ArrayList<Division> divisiones;
    ArrayList<Potenciacion> potenciaciones;

    public Operando(String entrada) {

        super(entrada);
        entrada = entrada.replace("-+", "-");
        entrada = entrada.replace("+-", "-");
        entrada = entrada.replace("/--", "/");
        entrada = entrada.replace("*--", "*");
        entrada = entrada.replace("^--", "^");
        entrada = entrada.replace("--", "+");
        //System.out.println(entrada);
        entrada = entrada.replace("/-", "/@");
        entrada = entrada.replace("*-", "*@");
        entrada = entrada.replace("^-", "^@");
        sumas = new ArrayList<>();
        restas = new ArrayList<>();
        multiplicaciones = new ArrayList<>();
        divisiones = new ArrayList<>();
        potenciaciones=new ArrayList<>();
        if (entrada.contains("+")) {
            Operacion.operar(entrada, (ArrayList<Operador>) (Object) sumas, "\\+", new Suma(""));
        } else if (entrada.contains("-")) {
            Operacion.operar(entrada, (ArrayList<Operador>) (Object) restas, "-", new Resta(""));

        } else if (entrada.contains("*")) {
            Operacion.operar(entrada, (ArrayList<Operador>) (Object) multiplicaciones, "\\*", new Multiplicacion(""));

        } else if (entrada.contains("/")) {
            Operacion.operar(entrada, (ArrayList<Operador>) (Object) divisiones, "/", new Division(""));
        } else if (entrada.contains("^")) {
            Operacion.operar(entrada, (ArrayList<Operador>) (Object) potenciaciones, "\\^", new Potenciacion(""));
        }

    }

    public void Operar() {

    }

    @Override
    public double resultado() {
        if (!sumas.isEmpty()) {
            return Operacion.sumar(sumas);
        } else if (!restas.isEmpty()) {
            return Operacion.restar(restas);
        }
        if (!multiplicaciones.isEmpty()) {
            return Operacion.multiplicar(multiplicaciones);
        } else if (!divisiones.isEmpty()) {
            return Operacion.dividir(divisiones);
        } else if (!potenciaciones.isEmpty()) {
            return Operacion.potenciar(potenciaciones);
        } else {
            return super.result;
        }
    }

    @Override
    public String toString() {
        if (!sumas.isEmpty()) {
            return "sumas:" + sumas.toString();

        } else if (!restas.isEmpty()) {
            return "resta:" + restas.toString();

        } else if (!multiplicaciones.isEmpty()) {
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
