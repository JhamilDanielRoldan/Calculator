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
class Resta extends Operador
{
	ArrayList<Multiplicacion>multiplicaciones;
	ArrayList<Division> divisiones;
	
	public Resta(String entrada)
	{
		super(entrada);
		multiplicaciones = new ArrayList<>();
		divisiones = new ArrayList<>();
		if (entrada.contains("*"))
		{
			Operacion.operar(entrada, (ArrayList<Operador>)(Object)multiplicaciones, "\\*", new Multiplicacion(""));
		}
		else if (entrada.contains("/"))
		{
			Operacion.operar(entrada, (ArrayList<Operador>)(Object)divisiones, "/", new Division(""));

		}
	}
	@Override
	public Operador opera(String entrada)
	{
		// TODO: Implement this method
		return new Resta(entrada);
	}

	@Override
	public double resultado()
	{
		
		if (!multiplicaciones.isEmpty())
		{
			return multiplicar();
		}
		else if (!divisiones.isEmpty())
		{
			return dividir();
		}

		else
		{
			return super.result;
		}
	}

	public double multiplicar()
	{
		double numero;
		numero = multiplicaciones.get(0).resultado();
		for (int n=1; n < multiplicaciones.size(); n++)
		{
			numero *= multiplicaciones.get(n).resultado();
		}
		return numero;
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
		if (!multiplicaciones.isEmpty())
		{
			return "multiplicacion:" + multiplicaciones.toString();
		}
		else if (!divisiones.isEmpty())
		{
			return "division:" + divisiones.toString();
		}
		else
		{
			return super.toString();
		}
	}

}
