/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jhamildanielrl
 */
public class Calculadora {
    private String marca;
    public Calculadora(String marca){
        this.marca=marca;
    }
    public int sumar(int sum1,int sum2 ){
        int res;
        res=sum1+sum2;
        return res;
    }
    public int restar(int res1,int res2 ){
        int res;
        res=res1-res2;
        return res;
    }
    public int multiplicar(int mul1,int mul2 ){
        int res;
        res=mul1*mul2;
        return res;
    }
    public int division(int div1,int div2 ){
        int res;
        res=div1/div2;
        return res;
    }
}
