/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programas;

import jdk.nashorn.tools.Shell;

/**
 *
 * @author Karen Vázquez
 */
public class Shellsort{
    public static void main(String[]args){
       int[]arreglo=new int[10];
        for (int i=0; i<arreglo.length; i++){
            arreglo [i] = (int)(Math.random() * 100) + 1;
        }
        shell(arreglo);
        for (int i=0; i<arreglo.length; i++){
            System.out.print(arreglo[i]+ ",");
        }
    }
    public static void shell(int[]arreglo){
        int salto=0, temp=0,i=0;
        boolean cambio;
        for(salto=arreglo.length/2;salto!=0;salto/=2){
            cambio=true;
            while(cambio){
                cambio=false;
                for(i=salto;i<arreglo.length;i++){
                    if(arreglo[i-salto]>arreglo[i]){
                        temp=arreglo[i];
                        arreglo[i]=arreglo[i-salto];
                        arreglo[i-salto]=temp;
                        cambio=true;
                    }
                        
                    }
                }
            }
        }
    }

