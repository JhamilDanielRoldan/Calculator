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
}
