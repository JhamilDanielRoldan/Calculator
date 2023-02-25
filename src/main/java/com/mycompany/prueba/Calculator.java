/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba;

/**
 *
 * @author jhamildanielrl
 */
public class Calculator {
    public static void main(String []args){
        String calcular="5+6-9*8-9*8/7";
        char [] datos=calcular.toCharArray();
        String buffer;
        double numero=0;
        buffer="";
        boolean dato=false;
        for(int n=0; n<datos.length; n++){
           if(datos[n]=='/'){
               numero=Double.parseDouble(buffer);
               buffer="";
               dato=true;
           }
           if(dato&&signeado(datos[n])){
               numero/=Double.parseDouble(buffer);
               System.out.println(numero);
               buffer="";
               dato=false;
           }
            buffer+=datos[n];    
        }
    }
    static char []signos={'*','/','+','-'};
    private static boolean signeado(char dato) {
        boolean confirma=false;
        for(char signo:signos){
            confirma= signo==dato;
        }
        return confirma;
    }
   
    
}
class Procesador{
    public void calcular(String entrada)
    {
        String []datos;
        Operacion operar=new Multiplicacion();
        if(entrada.contains(operar.getSigno())){
            
            datos=operar.separar(entrada);
            
        }
        
        
        
        
        
    }
}
class Operacion{
     String signo;
     public Operacion(){}
     //se agrega al constructor un signo, como tambien no depende
     public Operacion(String signo){
         this.signo=signo;
     }
     public String [] separar(String operaciones){
         String [] partes;
         partes=operaciones.split(signo);
         return partes;
     }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }
     
}
class Multiplicacion extends Operacion {
    public Multiplicacion(){
        signo="\\*";
    }
    public String getSigno() {
        if(signo.equals("\\*")){
            return "*";
          }
                return signo;
    }

   
    
    
}
class Divicion extends Operacion{
     public Divicion(){
        signo="/";
    }
}
class Suma extends Operacion{
    public Suma(){
        signo="+";
    }
}
class Resta extends Operacion{
    public Resta(){
        signo="-";
    }
}
