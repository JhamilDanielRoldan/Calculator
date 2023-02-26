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
class Multiplicacion extends Operador
{
	ArrayList<Division> divisiones;
	public Multiplicacion(String entrada)
	{
		super(entrada);
		divisiones = new ArrayList<>();
		if (entrada.contains("/"))
		{
			Operacion.operar(entrada, (ArrayList<Operador>)(Object)divisiones, "/", new Division(""));
		}

	}
	@Override
	public Operador opera(String entrada)
	{
		// TODO: Implement this method
		return new Multiplicacion(entrada);
	}
	@Override
	public double resultado()
	{
		
		if (!divisiones.isEmpty())
		{
			return dividir();
		}
		else
		{
			return super.result;
		}
	}
	public double dividir()
	{
		double numero;
		numero = divisiones.get(0).resultado();
		for (int n=1; n < divisiones.size(); n++)
		{
			numero /= divisiones.get(n).resultado();
		}
		return numero;
	}
	@Override
	public String toString()
	{
		if (!divisiones.isEmpty())
		{
			return "division:" + divisiones.toString();
		}
		else
		{
			return super.toString();
		}
	}

}