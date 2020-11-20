import java.util.Arrays;

class MetodosOrdenamiento{
	
	static class Burbuja{
		static long tInicio, tFin;
		public static void ordenacionBurbuja1(int [] numeros) {
			tInicio = System.nanoTime();
			for (int i = 1;i<=numeros.length; i++) {
				for (int j = 0;j<=numeros.length-i-1; j++) {
					if(numeros[j+1]<numeros[j]) {
						int aux =numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
						}
					}
				}
		
			
			tFin = System.nanoTime()-tInicio;
			System.out.println("Tiempo de ejecucion:" + tFin);
		}//Metodo OrdenacionBurbuja1
	public void ordenacionBurbuja2(int [] numeros) {
		
	}
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
		
		//LLenar el vector con 1 millon de datos aleatorios!!!!!
		int numeros[] = {6,2,9,7,1,0,4};
		
		MetodosOrdenamiento.Burbuja.mostrarVector(numeros);
		
		MetodosOrdenamiento.Burbuja.ordenacionBurbuja1(numeros);
		
		MetodosOrdenamiento.Burbuja.mostrarVector(numeros);
		
		/*Cantidad de pasadas
		 * Cantidad de comparaciones
		 * cantidad de intercambios 
		 */
		
		
	}

}
