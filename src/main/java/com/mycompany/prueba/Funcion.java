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
public class Funcion {
    private String entrada;
    public Funcion(String entrada) {

        while (entrada.contains(getClass().getSimpleName().toLowerCase())) {
            entrada = funcion(entrada);

        }
        this.entrada=entrada;
       

    }
    public Double resultado(){
       return new Operando(entrada).resultado();
    }

    private String funcion(String entrada) {
        ArrayList<ArrayList<Object>> mat = matriz(entrada);
        Operando op;
        double resultado;
        String signo;
        String resulta = "";
        int n = 0;
        int r = 0;
        while (!mat.get(n).get(0).equals(")")) {
            n++;
        }
        String salida = entrada.substring((Integer) mat.get(n - 1).get(1) + 1, (int) mat.get(n).get(1));
        op = new Operando(salida);
        resultado = operador(op.resultado());
        resulta = entrada.substring(0, (Integer) mat.get(n - 1).get(1) - 3 ) + resultado+ entrada.substring((Integer) mat.get(n).get(1) + 1, entrada.length());
        return resulta;
    }

    private  ArrayList<ArrayList<Object>> matriz(String entrada) {
        ArrayList<ArrayList<Object>> fanci;
        String nombreClase=getClass().getSimpleName().toLowerCase();
        fanci = new ArrayList<>();
        String buffer = "";
        for (int n = 0; n < entrada.length(); n++) {
            if (entrada.charAt(n) == '(') {
                if ( (entrada.substring(n-nombreClase.length(),n).toLowerCase()).equals(nombreClase)) {
                    ArrayList<Object> objeto = new ArrayList<>();
                    objeto.add(nombreClase+"(");
                    objeto.add(n);
                    fanci.add(objeto);
                }
            }
            if (entrada.charAt(n) == ')') {
                ArrayList<Object> objeto = new ArrayList<>();
                objeto.add(")");
                objeto.add(n);
                fanci.add(objeto);
            }
            buffer += entrada.charAt(n);
        }
        return fanci;
    }
    //implementar esto en las clases hijas
    protected double operador(double resultado) {
      return resultado;
    }
}

