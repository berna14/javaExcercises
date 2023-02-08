import java.util.Arrays;

public class Main {
    public static int moveZerosToLeft(int[] arr) {

        /* Creamos una variable insertIndex que va a ser igual a la longitud del array - 1.
        Esto se debe a que vamos a insertar los ceros a la izquierda del arreglo, de atras
        para adelante
        */


        int insertIndex = arr.length - 1;
        int currentIndex = 0;
        int count = 0;

        /* Dentro de este ciclo, si el elemento en i es distinto de 0, lo colocaremos en la posición
        actual de insertIndex y decrementamos la misma en 1.
         */

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[insertIndex--] = arr[i];
                count++;
            }
        }

        /* Luego creamos otro ciclo, en este caso while. Donde mientras insertIndex sea mayor o igual a
        0, colocaremos un 0 en la posicion actual del Index y lo incrementaremos en 1. Luego
        Decrementamos a insertIndex en 1.

         */

        while (insertIndex >= 0) {
            arr[currentIndex++] = 0;
            insertIndex--;
        }
        return count;
    }

    /*
    En el main, ponemos un array de enteros de ejemplo. Invocamos a la funcion anterior y la almacenamos
    en una variable int nonZeroElements. Luego mostramos dichos elementos en la consola al igual que el arreglo
    a traves de la funcion Arrays.toString().
     */

    public static void main(String[] args) {
        int[] arr = new int[] {1, 0, 2, 0, 0, 3, 4};
        int nonZeroElements = moveZerosToLeft(arr);
        System.out.println("Non-zero elements: " + nonZeroElements);
        System.out.println("Array: " + Arrays.toString(arr));
    }
}