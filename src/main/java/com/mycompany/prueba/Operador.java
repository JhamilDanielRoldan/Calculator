/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba;

/**
 *
 * @author jhamildanielrl
 */
class Operador
{
	protected double result;
	protected String dato;
	public Operador(String entrada)
	{
            
		
		try
		{
			result = Double.parseDouble(entrada);
			
		}
		catch (Exception es)
		{
                    
                    try{
                    if(entrada.charAt(0)=='@'){
                        result=-Double.parseDouble(entrada.substring(1,entrada.length()));
                        
                    }
                    }catch(Exception e){
                        
                    }
		
		}
	}
	public Operador opera(String entrada)
	{
		return this;
	}
	public double resultado()
	{
		return result;
	}

	@Override
	public String toString()
	{
		return result + "";
	}

}
