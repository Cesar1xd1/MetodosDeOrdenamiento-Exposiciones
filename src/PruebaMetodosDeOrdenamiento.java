import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

interface Correcion{
	Scanner input = new Scanner(System.in);
	
	public static int validacion() {
		int r = 0;
		boolean e = false;
		do {
			try {
				r = input.nextInt();
			} catch (java.util.InputMismatchException h) {
				System.out.println("Ups... Solo numeros porfavor, intenta de nuevo:");
				input.nextLine();
				e=true;
			}
			if (r>0) {
				e=false;
			}else {
				System.out.println("Solo numeros mayores a 0 por favor, intenta de nuevo:");
				e=true;
			}
		}while(e);
		return r;
	}
}


class MetodosOrdenamiento{
	static long tInicio, tFin;
	static int comparaciones=0, intercambios=0;
	static class Burbuja{
	
		
		public static void ordenacionBurbuja1(int [] numeros) {
			comparaciones = 0;
			comparaciones = 0;
			
			tInicio = System.nanoTime();
			for (int i = 1;i<=numeros.length; i++) {
				for (int j = 0;j<=numeros.length-i-1; j++) {
					comparaciones = comparaciones + 1;
					if(numeros[j+1]<numeros[j]) {
						intercambios = intercambios +1;
						int aux =numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
						}
					}
				}
		
			
			tFin = System.nanoTime()-tInicio;
			System.out.println("Tiempo de ejecucion:" + tFin);
			System.out.println("Numero de intercambios = " + intercambios);
			System.out.println("Numeor de comparaciones = " + comparaciones);
			tInicio = 0;
			tFin = 0;
		}//Metodo OrdenacionBurbuja1
		public static void ordenacionBurbuja2(int[] numeros) {
			System.out.println("======ordenacionBurbuja2======");
			comparaciones=0;
			intercambios=0;
			
			int i =1;
			boolean o=false;
			tInicio = System.nanoTime();
			while (i<numeros.length) {
				i+=1;
				o=true;
				for (int j = 0; j < numeros.length-i-1; j++) {
					
					if(numeros[j]>numeros[j+1]) {
						
						o=false;
						int aux = numeros[j];
						numeros[j]=numeros[j+1];
						numeros[j+1]=aux;
						intercambios= intercambios + 1;
					}
					comparaciones= comparaciones +1;
				}
			}
			tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion:"+(tFin-tInicio));
			System.out.println("Numero de intercambios: "+intercambios);
			System.out.println("Numero de comparaciones: "+comparaciones);
		}
		public static void ordenacionBurbuja3(int[] nums) {
			int[] numeros = nums;
			comparaciones=0;
			intercambios=0;
			
			int i =1;
			tInicio = System.nanoTime();
			do{
				i+=1;
				boolean o=true;
				for (int j = 0; j < numeros.length-i; j++) {
					
					if(numeros[j]>numeros[j+1]) {
						o=false;
						int aux = numeros[j];
						numeros[j]=numeros[j+1];
						numeros[j+1]=aux;
						intercambios+=1;
					}
					comparaciones+=1;
				}
			}while (i<numeros.length);
			tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion:"+(tFin-tInicio));
			System.out.println("Numero de intercambios: "+intercambios);
			System.out.println("Numero de comparaciones: "+comparaciones);
			tFin = 0;
			tInicio = 0;
		}
	
	public static void mostrarVector(int [] numeros) {
		System.out.println(Arrays.toString(numeros));
	}
	
	
		
	
	}//Class Burbuja
	
	static class Insercion{
		public static void ordenarInsercion(int [] numeros) {
			int aux;
			tInicio = 0;
			tFin = 0;
			intercambios = 0;
			comparaciones = 0;
			tInicio = System.nanoTime();
			for (int i = 1; i < numeros.length; i++) {
				aux=numeros[i];
				for (int j = i-1; j>=0 && numeros[j]>aux; j--) {
					numeros[j+1]=numeros[j];
					numeros[j]=aux;
				}
			}
			tFin=System.nanoTime();
			System.out.println("Tiempo de ejecucion: " + (tFin-tInicio));
		}

	}//Class Insercion}
	
	static class Seleccion{
		static public void ordenamientoSeleccion(int[] numeros) {
			tInicio = 0;
			tFin = 0;
			intercambios = 0;
			comparaciones = 0;
			tInicio = System.nanoTime();
			for (int i = 0; i < numeros.length-1; i++) {
			for (int j = i; j < numeros.length; j++) {
				comparaciones = comparaciones +1;
				if(numeros[i]>numeros[j]) {
					intercambios = intercambios +1;
					int minimo = numeros[i];
					numeros[i] = numeros[j];
					numeros[j]= minimo;
				}
				
			}
				
			}
			tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion: " + (tFin-tInicio));
			System.out.println("Numero de intercambios: " + intercambios);
			System.out.println("Numero de comparaciones: " + comparaciones);
		}
	}//class seleccion
	
	
	static class Quiqsort{
		static public int[] quicksort(int[] numeros,int izq,int der) {
			int pivote = numeros[izq];
			int i = izq, j = der;
			int aux;
			while(i<j) {
				while(numeros[i]<=pivote && i<j) i++;
				while(numeros[j]>pivote)j--;
				if(i<j) {
					aux = numeros[i];
					numeros[i]=numeros[j];
					numeros[j] = aux;
				}
			}
			numeros[izq]=numeros[j];
			numeros[j]=pivote;
			if(izq<j-1)
				quicksort(numeros,izq,j-1);
			if(j+1<der)
				quicksort(numeros, j+1, der);
			return numeros;
		}
	}//Quicksort

	static class Shellsort{
		static public void sellsort(int[] numeros) {
			int intervalo = numeros.length/2;
			while(intervalo>0) {
				for(int i = intervalo; numeros.length>i;i++ ) {
					int j = i-intervalo;
					while(j>=0) {
						int k = j+intervalo;
						if(numeros[j]<=numeros[k]) {
							j =-1;
							
						}else {
							int aux = numeros[j];
							numeros[j] = numeros[k];
							numeros[k] = aux;
							j-=intervalo;
						}
					}
				}
				intervalo = intervalo/2;
			}
		}
}//Shellsort
	
	
	
}//CLass MetodosOrdenamiento




public class PruebaMetodosDeOrdenamiento {

	public static void main(String[] args) {
		
		
		
		
		
		//Agregar MENU!
		int opcion = 0;
		
		//Random aleatorio = new Random(System.currentTimeMillis());
		
		
		
		int numeros[] = {23,34,12,4,2,67,1,11,5,4,7,9,10};
		int numeros2[];
		do{
			
			numeros2 = numeros.clone();
			System.out.println("======================== MENU ========================");
			System.out.println("Digite 1 para usar el metodo de ordenacion BURBUJA");
			System.out.println("Digite 2 para usar el metodo de Ordenamiento INSERCION");
			System.out.println("Digite 3 para usar el metodo de Ordenamiento SELECCION ");
			System.out.println("Digite 4 para usar el metodo de Ordenamiento QUICKSORT");
			System.out.println("Digite 5 para usar el metodo de Ordenamiento SHELLSORT");
			System.out.println("Digite 6 para ***SALIR***");
			opcion = Correcion.validacion();
			switch (opcion) {
			case 1:
				//numeros2 = numeros;
				System.out.println("Digite 1 para usar el metodo de Burbuja 1");
				System.out.println("Digite 2 para usar el metodo de Burbuja 2");
				System.out.println("Digite 3 para usar el metodo de Burbuja 3");
				int op2 = Correcion.validacion();
				if(op2==1) {
					System.out.println("Metodo de la burbuaja #1");
					System.out.println("===== Vector DESORDENADO =====");
					MetodosOrdenamiento.Burbuja.mostrarVector(numeros2);
					MetodosOrdenamiento.Burbuja.ordenacionBurbuja1(numeros2);
					System.out.println("===== Vector ORDENADO =====");
					MetodosOrdenamiento.Burbuja.mostrarVector(numeros2);
				}else if(op2==2) {
					System.out.println("Metodo de la burbuaja #2");
					System.out.println("===== Vector DESORDENADO =====");
					MetodosOrdenamiento.Burbuja.mostrarVector(numeros2);
					MetodosOrdenamiento.Burbuja.ordenacionBurbuja2(numeros2);
					System.out.println("===== Vector ORDENADO =====");
					MetodosOrdenamiento.Burbuja.mostrarVector(numeros2);
				}else if(op2==3){
					System.out.println("Metodo de la burbuaja #2");
					System.out.println("===== Vector DESORDENADO =====");
					MetodosOrdenamiento.Burbuja.mostrarVector(numeros2);
					MetodosOrdenamiento.Burbuja.ordenacionBurbuja2(numeros2);
					System.out.println("===== Vector ORDENADO =====");
					MetodosOrdenamiento.Burbuja.mostrarVector(numeros2);
				}else {
					System.out.println("Opcion no disponible");
				}
				break;
			case 2: 
				//numeros2 = numeros;
				System.out.println("=== Metodo de Insercion ===");
				System.out.println("Desordenados:" + Arrays.toString(numeros2));
				MetodosOrdenamiento.Insercion.ordenarInsercion(numeros2);
				System.out.println("Ordenados: " + Arrays.toString(numeros2));
					break;
			case 4:
				System.out.println("===== Metodo de QuickSort =====");
				numeros2 = numeros;
				System.out.println("Desordenado: " + Arrays.toString(numeros2));
				MetodosOrdenamiento.Quiqsort.quicksort(numeros2, 0, numeros2.length-1);
				System.out.println("Ordenado: " + Arrays.toString(numeros2));break;
			case 3:
				//numeros2 = numeros;
				System.out.println("===== Metodo de Seleccion ===== ");
				System.out.println("Desordenados: " + Arrays.toString(numeros2));
				MetodosOrdenamiento.Seleccion.ordenamientoSeleccion(numeros2);
				System.out.println("Ordenado: " + Arrays.toString(numeros2));break;
			case 6: 
				System.out.println("Gracias por usar");
				break;
			case 5:
				System.out.println("===== Metodo de Seleccion ===== ");
				System.out.println("Desordenados: " + Arrays.toString(numeros2));
				MetodosOrdenamiento.Shellsort.sellsort(numeros2);
				System.out.println("Ordenado: " + Arrays.toString(numeros2));break;
				
			}
			
		}while (opcion!=6);//Usar aqui el numero de ***SALIR***
		
		
		
		
		//LLenar el vector con 1 millon de datos aleatorios!!!!!
		
		
		/*Cantidad de pasadas
		 * Cantidad de comparaciones
		 * cantidad de intercambios 
		 */
	
		
	}

}
