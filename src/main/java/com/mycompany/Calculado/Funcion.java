package com.mycompany.Calculado;

import java.util.ArrayList;
import java.util.FormatterClosedException;

/**
 *
 * @author jhamildanielrl
 */
public class Funcion {

    private String entrada;
    String[] operaciones = {"cos", "sin", "tan", "pan"};

    public Funcion(String entrada) {
        verificarParentesis(entrada);
        entrada = convertParent(entrada);
        for (int n = 0; n < operaciones.length; n++) {
            entrada = evaluar(operaciones[n], entrada);
        }
        this.entrada = entrada;

    }

    private String evaluar(String funcion, String ent) {
        while (ent.contains(funcion)) {
            ent = funcion(ent, funcion);
        }
        return ent;
    }

    public String resultado() {
        return entrada;
    }

    private String funcion(String entrada, String funcion) {
        ArrayList<ArrayList<Object>> mat = matriz(entrada, funcion);
        // System.out.println(mat);
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
        //TODO agregar aqui tang sec y demas funciones
        resultado = 0;
        if (mat.get(n - 1).get(0).equals("cos(")) {
            resultado = Math.cos(op.resultado());
        } else if (mat.get(n - 1).get(0).equals("sin(")) {
            resultado = Math.sin(op.resultado());
        } else if (mat.get(n - 1).get(0).equals("tan(")) {
            resultado = Math.tan(op.resultado());
        } else {
            resultado = op.resultado();
        }
        resulta = entrada.substring(0, (Integer) mat.get(n - 1).get(1) - funcion.length()) + resultado + entrada.substring((Integer) mat.get(n).get(1) + 1, entrada.length());
        return resulta;
    }

    private ArrayList<ArrayList<Object>> matriz(String entrada, String funcion) {
        ArrayList<ArrayList<Object>> fanci;
        String nombreClase = funcion;
        fanci = new ArrayList<>();
        String buffer = "";
        String operador;
        for (int n = 0; n < entrada.length(); n++) {
            if (entrada.charAt(n) == '(') {
                operador = (entrada.substring(n - nombreClase.length(), n).toLowerCase());
                if (evaluarF(operador)) {
                    ArrayList<Object> objeto = new ArrayList<>();
                    objeto.add(operador + "(");
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

    public boolean evaluarF(String operador) {
        boolean salida = false;
        for (int n = 0; n < operaciones.length; n++) {
            if (operador.equals(operaciones[n])) {
                salida = true;
            }
        }
        return salida;
    }

    //implementar esto en las clases hijas
    protected double operador(double resultado) {
        return resultado;
    }

    private String convertParent(String entrada) {
        String salida = "";
        salida = entrada;
        do {
            salida = salida.replace("((", "(pan(");
        } while (salida.contains("(("));

        salida = salida.replace("+(", "+pan(");
        salida = salida.replace("-(", "-pan(");
        salida = salida.replace("/(", "/pan(");
        salida = salida.replace("^(", "^pan(");
        if (entrada.charAt(0) == '(') {
            salida = "pan" + salida;
        }
        System.out.println("INFO:Funcion y parentesis: " + salida);
        return salida;
    }

    public boolean operaciones(char entrada) {
        char[] op = {'+', '-', '*', '/', '^'};
        boolean salida = false;
        for (char f : op) {
            if (f == entrada) {
                salida = true;
            }
        }
        return salida;
    }

    private void verificarParentesis(String entrada) {

        char[] ent = entrada.toCharArray();
        ArrayList<Character> parentesis = new ArrayList<>();
        for (char letr : ent) {
            if (letr == '(') {
                parentesis.add(')');
            } else if (letr == ')') {
                if (!parentesis.isEmpty()) {
                    char removido = parentesis.remove(parentesis.size() - 1);

                    if (removido != ')') {
                        throw new NumberFormatException("error con parentesis");
                    }
                } else {
                    throw new NumberFormatException("error con parentesis");
                }
            }
        }
        if (parentesis.size() != 0) {
            throw new NumberFormatException("error con parentesis");
        }
    }

}
