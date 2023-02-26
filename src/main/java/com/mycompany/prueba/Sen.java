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
public class Sen {
private String entrada;
    public Sen(String entrada) {

        while (entrada.contains("sen")) {
            entrada = UnSen(entrada);

        }
        this.entrada=entrada;
       

    }
    public Double resultado(){
       return new Operando(entrada).resultado();
    }

    public String UnSen(String entrada) {
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
        //System.out.println(mat.get(n).get(1)+"y"+n);
        String salida = entrada.substring((Integer) mat.get(n - 1).get(1) + 1, (int) mat.get(n).get(1));
        op = new Operando(salida);
        resultado = Math.sin(op.resultado());
        resulta = entrada.substring(0, (Integer) mat.get(n - 1).get(1) - 3 ) + resultado+ entrada.substring((Integer) mat.get(n).get(1) + 1, entrada.length());
        return resulta;
    }

    public ArrayList<ArrayList<Object>> matriz(String entrada) {
        ArrayList<ArrayList<Object>> sen;
        sen = new ArrayList<>();
        String buffer = "";
        for (int n = 0; n < entrada.length(); n++) {
            if (entrada.charAt(n) == '(') {
                if (entrada.charAt(n - 3) == 's') {
                    ArrayList<Object> objeto = new ArrayList<>();
                    objeto.add("sen(");
                    objeto.add(n);
                    sen.add(objeto);
                }
            }
            if (entrada.charAt(n) == ')') {
                ArrayList<Object> objeto = new ArrayList<>();
                objeto.add(")");
                objeto.add(n);
                sen.add(objeto);
            }
            buffer += entrada.charAt(n);
        }
        return sen;
    }
}
