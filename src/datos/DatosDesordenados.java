package datos;

import java.util.Arrays;
import programas.QuickSort;

/**
 *
 * @author Noemí Lara Acono
 */
public class DatosDesordenados {
    // Atributos
    private int[] valores; 
    private int limiteSuperior; 
    private int size; 

    public DatosDesordenados(int limite, int size) {
        this.valores = new int[size];
        this.limiteSuperior = limite;
        this.size = size;
    }
    
    public void agregarDato(int valor){
        valores[size]= valor;
        size++;
    }
    
    public int getDato(int posicion){
        return valores[posicion];
    }
    
    public void generarValores(){
        for (int i=0; i < valores.length; i++){
            double aleatorio = Math.random() * limiteSuperior;
            valores[i] = (int) aleatorio + 1;
        }
    }
    
    public int getSize(){
        return size; 
    }
    
    public int getCapacidad(){
        return valores.length;
    }
    
    public int getLimiteSuperior(){
        return limiteSuperior;
    }
    
    
    public int[] getValores(){
        return valores;
    } 
    
    public int[] getCopiaValores(){
        int [] copia = new int[size];
        System.arraycopy(valores, 0, copia, 0, size);
        return copia;
    }
    
    
   
     public DatosOrdenados algoritmoSort(){
        
        // obtener una copia de los datos desordenados
        int [] arreglo = this.getCopiaValores();
        
        // agregar algoritmo de ordenación
        
        // devolver los datos ordenados
        return new DatosOrdenados(arreglo);
    }
    
    public DatosOrdenados bubbleSort(){
        int [] arreglo = this.getCopiaValores();
        int n = arreglo.length;
        int cont = 0;
        int ci = 0;
        for (int i=0; i < n-1; i++){
            for (int j=0; j < n-i-1; j++){
                cont++;
                if (arreglo[j] > arreglo[j+1]){
                    // intercambiar: swap
                    ci++;
                    int temporal = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = temporal;
                }
            }
        }
        System.out.println("BS-comparaciones = " + cont);
        System.out.println("BS-intercambios = " + ci);
        return new DatosOrdenados(arreglo);
    }
    
        public DatosOrdenados Quicksort(){
        int [] numeros  = this.getCopiaValores();
      
        
        //Llamada Metodo de Ordenamiento QuickSort
        Quicksort(numeros, 0, numeros.length -1);
        
        //Metodo para imprimir Vector Ordenado
         ImprimirVector(numeros);
         return new DatosOrdenados(numeros );
    }

    //Metodo de Ordenamiento QuickSort
    public void Quicksort(int numeros[], int izq, int der)
    {
            /*Este metodo recibe un arreglo de numero, y dos enteros que referencian el primer valor
            Y el ultimo*/
        
            //Se toma como pivote el primer valor
            int pivote = numeros[izq];
            
            //Se definen los dos lados y un auxiliar
            int i = izq; 
            int j = der; 
            int aux;
           
            while(i<j)
            {
               while (numeros[i] <= pivote && i < j) 
                  i++;

               while (numeros[j] > pivote) 
                  j--;   

               if (i<j) 
               {                                     
                   aux = numeros[i];                  
                   numeros[i]= numeros[j];
                   numeros[j]=aux;
               }
            }

             numeros[izq] = numeros[j]; 
             numeros[j] = pivote;

             if (izq < j-1)
                Quicksort(numeros,izq,j-1);

             if (j+1 < der)
                Quicksort(numeros,j+1,der);
      }
    
    public static void ImprimirVector(int arreglo[])
    {
        for(int i = 0; i < arreglo.length; i++)
        {
            System.out.println(arreglo[i]);
        }
    }
            
     public DatosOrdenados Radix(){
         int [] arr  = this.getCopiaValores();	
            //int arr[] = {53,3,542,748,14,214};
		Radix (arr);
		System.out.println(Arrays.toString(arr));
                 return new DatosOrdenados(arr);
	}
	public static void Radix (int[] arr) {
		int[][] bucket = new int[10][arr.length];
		int[] bucketOfElement = new int[10];
		int max=0;
		// Encuentra el elemento más grande en la matriz
		for(int i = 0 ; i < arr.length;i++) {
			if(arr[i]>max){
				max = arr[i];
			}
		}
		// Calcula el número de bits del elemento más grande
		int maxLength = (max+"").length();
		for(int m = 0,n=1;m<maxLength;m++,n*=10) {
			// Coloca los números en arr en los cubos correspondientes según sus unidades, decenas, centenas, etc.
			for(int i = 0 ; i < arr.length;i++) {
				int digit = arr[i]/n%10;
				// Asignar el valor de arr [i] a la matriz bidimensional en el depósito
				bucket[digit][bucketOfElement[digit]] = arr[i];
				bucketOfElement[digit]++;
			}
			int index = 0;
			// Leer los elementos en el depósito y reasignarlos a arr
			for(int j = 0;j<10;j++) {
				for(int k = 0 ; k<bucketOfElement[j];k++) {
					arr[index] = bucket[j][k];
					index++;
				}
				bucketOfElement[j]=0;// Borrar el número de elementos en cada uno
			}
			}
		}

     public DatosOrdenados Shellsort(){
         int [] a  = this.getCopiaValores();	
        shell(a);
        for (int i=0; i<a.length; i++){
            System.out.print(a[i]+ ",");
        }
         return new DatosOrdenados(a);
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
     
     
     

         

    public DatosOrdenados insertSort(){
         // obtener una copia de los datos desordenados
        int [] a = this.getCopiaValores();
        
	int i, j, aux; 
	int cont=0; 
	for ( i = 1; i < a.length; i++){
		j = i;
		aux = a[i];
		while (j >0 && aux < a[j-1]){
                   cont++;
                   a[j] = a[j-1];
                   j--; 
		}
		a[j] = aux; 
	}
        System.out.println("IS-comparaciones = " + cont);
	// devolver los datos ordenados
        return new DatosOrdenados(a);
    }
    
    public DatosOrdenados mergeSort(){
    int [] x = this.getCopiaValores();
	// Aquí va la llamada al método mergesort( arreglo, l, r)
	this.mergesort( x, 0, x.length - 1);
        System.out.println("MS-comparaciones = " + cm);
	return new DatosOrdenados(x);
    } // fin del método ordenacionMerge
    
   private void mergesort (int v[], int l, int r) {
		 int m = (r+l)/2; 
		 if (r > l) { 
                     cm++;
			 mergesort (v, l, m);
			 mergesort (v, m+1, r); 
			 merge (v, l, m, r); 
		 }
	}
    static int cm=0;
   private void merge (int v[], int l, int m, int r)
	{
	//Encuentra el tamaño de los sub-vectores para unirlos.
	  int n1 = m - l + 1;
	  int n2 = r - m;

	  //Vectores temporales.
	  int arrIzq[] = new int [n1];
	  int arrDer[] = new int [n2];

	  //Copia los datos a los arreglos temporales.
	  for (int i=0; i < n1; i++) {
              cm++;
		arrIzq[i] = v[l+i];
	  }
	  for (int j=0; j < n2; j++) {
              cm++;
		arrDer[j] = v[m + j + 1];
	  }
	  // Combinación (mezcla) de los dos arreglos:
	  int i = 0, j = 0;
	  int k = l;
	  while (i < n1 && j < n2) {//Ordenamiento.
                cm++;
		if (arrIzq[i] <= arrDer[j]) {
			v[k] = arrIzq[i];
			i++;
		} else {
			v[k] = arrDer[j];
			j++;
		}
		k++;
	  }//Fin del while.

	  /* Si quedan elementos por ordenar */
	  //Copiar los elementos restantes de arrIzq[].
	  while (i < n1) {
              cm++;
	    v[k] = arrIzq[i];
	    i++;
	    k++;
	  }
	  //Copiar los elementos restantes de arrDer[].
	  while (j < n2) {
              cm++;
	    v[k] = arrDer[j];
	    j++;
	    k++;
	  }
	}
    
    @Override
    public String toString(){
        String cad = "Datos DESORDENADOS: ";
        for (int x : valores){
            cad += x + ", ";
        }
        return cad;
    }
    
    
    
}
