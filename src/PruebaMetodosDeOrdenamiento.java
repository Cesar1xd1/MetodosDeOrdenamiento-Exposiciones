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
	static class RadixSort{
		static public void radix(int[] numeros) {
			 if(numeros.length == 0)
	              return;
	              int[][] np = new int[numeros.length][2];
	              int[] q = new int[0x100];
	              int i,j,k,l,f = 0;
	              for(k=0;k<4;k++) {
	                 for(i=0;i<(np.length-1);i++)
	                 np[i][1] = i+1;
	                 np[i][1] = -1;
	                 for(i=0;i<q.length;i++)
	                 q[i] = -1;
	                 for(f=i=0;i<numeros.length;i++) {
	                    j = ((0xFF<<(k<<3))&numeros[i])>>(k<<3);
	                    if(q[j] == -1)
	                    l = q[j] = f;
	                 else {
	                    l = q[j];
	                    while(np[l][1] != -1)
	                    l = np[l][1];
	                    np[l][1] = f;
	                    l = np[l][1];
	                 }
	                 f = np[f][1];
	                 np[l][0] = numeros[i];
	                 np[l][1] = -1;
	              }
	              for(l=q[i=j=0];i<0x100;i++)
	              for(l=q[i];l!=-1;l=np[l][1])
	                  numeros[j++] = np[l][0];
	           }//for
	    }//metodo
	}//class Radix
	
static class Intercalacion{
public static int[] intercalacion(int primero[],int segundo[]) {
		
		int arrayOrdenado[] = new int[primero.length+segundo.length];
		
		int i=0,j=0,k=0;
		
		while(i<primero.length && j<segundo.length) {
			if(primero[i]<segundo[j]) {
				arrayOrdenado[k]=primero[i];
				k++;
				i++;
			}else {
				arrayOrdenado[k]=segundo[j];
				k++;
				j++;
			}
		}
		while(j<segundo.length) {
			arrayOrdenado[k]=segundo[j];
			j++;
			k++;
		}
		while(i<primero.length) {
			arrayOrdenado[k]=segundo[j];
			j++;
			k++;
		}
		
		return arrayOrdenado;
	}
}
	
	
	
	
static class MezclaDirecta{
	static public int[] mezcladirecta(int[] numeros) {
		int i,j,k;
		if(numeros.length >1 ) {
			int izq = numeros.length/2;
			int der = numeros.length-izq;
			
			int izquierdo[] = new int[izq];
			int derecho[] = new int [der];
			
			for (i = 0; i < izq; i++) {
				izquierdo[i]=numeros[i];
			}
			for(i=izq;i<izq+der;i++ ) {
				derecho[i-izq]=numeros[i];
			}
			izquierdo = mezcladirecta(izquierdo);
			derecho = mezcladirecta(derecho);
			i=j=k=0;
			
			while(izquierdo.length!=j && derecho.length!=k) {
				if(izquierdo[j]<derecho[k]) {
					numeros[i]=izquierdo[j];
					i++;
					j++;
				}else {
						numeros[i]=derecho[k];
					i++;
					k++;
				}
			}
			while(izquierdo.length!=j) {
				numeros[i]=izquierdo[j];
				i++;
				j++;
			}
			while(derecho.length!=k) {
				numeros[i]=derecho[k];
				i++;
				k++;
			}
		}
		return numeros;
	}
}//MEzcla directa
	
	
	
	
}//CLass MetodosOrdenamiento




public class PruebaMetodosDeOrdenamiento {

	public static void main(String[] args) {
		
		
		
		
		
		//Agregar MENU!
		int opcion = 0;
		
		//Random aleatorio = new Random(System.currentTimeMillis());
		
		
		
		int numeros[] = {23,34,12,4,2,67,1,11,5,4,7,9,10};
		int numeros2[];
		int aux[]= {2,19,30,59,102,215,256,316};
		int aux2[];
		do{
			
			numeros2 = numeros.clone();
			aux2 = aux.clone();
			System.out.println("======================== MENU ========================");
			System.out.println("Digite 1 para usar el metodo de ordenacion BURBUJA");
			System.out.println("Digite 2 para usar el metodo de Ordenamiento INSERCION");
			System.out.println("Digite 3 para usar el metodo de Ordenamiento SELECCION ");
			System.out.println("Digite 4 para usar el metodo de Ordenamiento QUICKSORT");
			System.out.println("Digite 5 para usar el metodo de Ordenamiento SHELLSORT");
			System.out.println("Digite 6 para usar el metodo de Ordenamiento RADIX");
			System.out.println("Digite 7 para usar el metodo de Ordenamiento INTERCALACION");
			System.out.println("Digite 8 para usar el metodo de Ordenamiento de MEZCLA DIRECTA");
			System.out.println("Digite 9 para ***SALIR***");
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
			case 9: 
				System.out.println("Gracias por usar");
				break;
			case 5:
				System.out.println("===== Metodo de Shellsort ===== ");
				System.out.println("Desordenados: " + Arrays.toString(numeros2));
				MetodosOrdenamiento.Shellsort.sellsort(numeros2);
				System.out.println("Ordenado: " + Arrays.toString(numeros2));break;
			case 6:
				System.out.println("===== Metodo de RadixSort ===== ");
				System.out.println("Desordenados: " + Arrays.toString(numeros2));
				MetodosOrdenamiento.RadixSort.radix(numeros2);
				System.out.println("Ordenado: " + Arrays.toString(numeros2));break;
			case 8:
				System.out.println("===== Metodo de Mezcla Directa =====");
				System.out.println("Desordenado" + Arrays.toString(numeros2));
				MetodosOrdenamiento.MezclaDirecta.mezcladirecta(numeros2);
				System.out.println("Ordenado " + Arrays.toString(numeros2));break;
			case 7:
				System.out.println("===== Metodo de Intercalación =====");
				System.out.println("Vectores:");
				System.out.println(Arrays.toString(numeros2));
				System.out.println(Arrays.toString(aux2));
				System.out.println("Ordenado y fusionado: " + Arrays.toString(MetodosOrdenamiento.Intercalacion.intercalacion(MetodosOrdenamiento.MezclaDirecta.mezcladirecta(numeros2), MetodosOrdenamiento.MezclaDirecta.mezcladirecta(aux2))));break;
				//El segundo vector tambien se ordena en caso de que se llegue a desordenar 
			}
		}while (opcion!=9);//Usar aqui el numero de ***SALIR***		
	}

}
