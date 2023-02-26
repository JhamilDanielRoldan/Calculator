/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jhamildanielrl
 */
class Operando extends Operador
{
	ArrayList<Suma> sumas;
	ArrayList <Resta> restas;
	ArrayList <Multiplicacion> multiplicaciones;
	ArrayList <Division> divisiones;
	public Operando(String entrada)
	{
            
		super(entrada);
                entrada=entrada.replace("-+", "-");
                entrada=entrada.replace("+-", "-");
                entrada=entrada.replace("/-", "/@");
                entrada=entrada.replace("*-","*@");
		sumas = new ArrayList<>();
		restas = new ArrayList<>();
		multiplicaciones = new ArrayList<>();
		divisiones = new ArrayList<>();
               
		if (entrada.contains("+"))
		{
			Operacion.operar(entrada, (ArrayList<Operador>)(Object)sumas, "\\+", new Suma(""));
		}
		else if (entrada.contains("-"))
		{
			Operacion.operar(entrada, (ArrayList<Operador>)(Object)restas, "-", new Resta(""));
                        
		}
		else if (entrada.contains("*"))
		{
			Operacion.operar(entrada, (ArrayList<Operador>)(Object)multiplicaciones, "\\*", new Multiplicacion(""));
			
		}
		else if (entrada.contains("/"))
		{
			Operacion.operar(entrada, (ArrayList<Operador>)(Object)divisiones, "/", new Division(""));
		}
		
		
	}
	public void Operar()
	{

	}
	@Override
	public double resultado()
	{
		if (!sumas.isEmpty())
		{
			return sumar();
		}
		else if (!restas.isEmpty())
		{
			return restar();
		}
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
	public double sumar()
	{
		double numero;
		numero = sumas.get(0).resultado();
		for (int n=1; n < sumas.size(); n++)
		{
			numero += sumas.get(n).resultado();
		}
		return numero;
	}
	public double restar() {

        double numero;
        numero = restas.get(0).resultado();
        for (int n = 1; n < restas.size(); n++) {
                numero -= restas.get(n).resultado();
        }
        return numero;
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
		if (!sumas.isEmpty())
		{
			return "sumas:" + sumas.toString();

		}
		else if (!restas.isEmpty())
		{
			return "resta:" + restas.toString();

		}
		else if (!multiplicaciones.isEmpty())
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

    private String quitarCorrupcion(String entrada) {
        int ubicacion;
        ubicacion=entrada.indexOf("/-");
        char []operaciones={'+','-','/','*','s'};
        System.out.println(ubicacion);
        return null;
    }
}
