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
class Operacion
{
	public static void operar(String entrada, ArrayList<Operador> lista, String operando, Operador opr)
	{
		String corrupt,operis[],corregidor[];
		Operador operacion;
		operis = entrada.split(operando);
                
		for (String oper:operis)
		{
			operacion = opr.opera(oper);
			lista.add(operacion);
		}

	}
        public double sumar(ArrayList <Resta> sumas)
	{
		double numero;
		numero = sumas.get(0).resultado();
		for (int n=1; n < sumas.size(); n++)
		{
			numero += sumas.get(n).resultado();
		}
		return numero;
	}
	public double restar(ArrayList <Resta> restas) {

        double numero;
        numero = restas.get(0).resultado();
        for (int n = 1; n < restas.size(); n++) {
                numero -= restas.get(n).resultado();
        }
        return numero;
    }
	public double multiplicar(ArrayList <Multiplicacion> multiplicaciones)
	{
		double numero;
		numero = multiplicaciones.get(0).resultado();
		for (int n=1; n < multiplicaciones.size(); n++)
		{
			numero *= multiplicaciones.get(n).resultado();
		}
		return numero;
	}
	public double dividir(ArrayList <Division> divisiones)
	{
		double numero;
		numero = divisiones.get(0).resultado();
		for (int n=1; n < divisiones.size(); n++)
		{
			numero /= divisiones.get(n).resultado();
		}
		return numero;
	}
}
