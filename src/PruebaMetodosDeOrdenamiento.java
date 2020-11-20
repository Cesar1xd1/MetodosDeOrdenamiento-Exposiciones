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
	
	static class Burbuja{
		static long tInicio, tFin;
		
		public static void ordenacionBurbuja1(int [] numeros) {
		
			int comparaciones=0, intercambios=0;
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
		}//Metodo OrdenacionBurbuja1
	public void ordenacionBurbuja2(int [] numeros) {
		
	}//Metodo OrdenacionBurbuja2
	public void ordenacionBurbuja3(int [] numeros) {
		
	}
	
	public static void mostrarVector(int [] numeros) {
		System.out.println(Arrays.toString(numeros));
	}

		
	
	}//Class Burbuja
	
	
}//CLass MetodosOrdenamiento




public class PruebaMetodosDeOrdenamiento {

	public static void main(String[] args) {
		//Agregar MENU!
		int opcion = 0;
		do{
			System.out.println("=================== MENU ===================");
			System.out.println("Digite 1 para usar el metodo de ordenacion BURBUJA");
			System.out.println("Digite 2 para ***SALIR***");
			opcion = Correcion.validacion();
			switch (opcion) {
			case 1:
				Random aleatorio = new Random(System.currentTimeMillis());
				int numeros[] = new int[1000];
				for (int i = 0; i <1000; i++) {
					int intAletorio = aleatorio.nextInt(1000);
					numeros[i]=intAletorio +1;
				}
				System.out.println("===== Vector DESORDENADO =====");
				MetodosOrdenamiento.Burbuja.mostrarVector(numeros);
				MetodosOrdenamiento.Burbuja.ordenacionBurbuja1(numeros);
				System.out.println("===== Vector ORDENADO =====");
				MetodosOrdenamiento.Burbuja.mostrarVector(numeros);
				break;

			case 2://Cambiar para la opcion SALIR
				System.out.println("Gracias por usar");
				break;
			}
			
		}while (opcion!=2);//Usar aqui el numero de ***SALIR***
		
		
		
		
		//LLenar el vector con 1 millon de datos aleatorios!!!!!
		
		
		/*Cantidad de pasadas
		 * Cantidad de comparaciones
		 * cantidad de intercambios 
		 */
	
		
	}

}
