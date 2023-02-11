import java.util.Arrays;
import java.util.Comparator;

public class SumDifferences {

    /*
    En este ejercicio necesitamos ordenar un arreglo de enteros de manera descendiente, para poder asi,
    sumar las diferencias entre los consecutivos en dicho array. Para ello, realizamos lo siguiente:
     */

    public static int sumOfDifferences(int[] arr){

        /*
        Para ordenar el array, vamos a utilizar el metodo sort. Pero cuando vamos a realizar el ejercicio
        nos encontramos con un problema. Este metodo "sort" solo funciona para array de objetos, no para
        primitivos. Para ello, debemos convertir dicho array de primitivos a un array de objetos de tipo Integer
         */

        /*
        Esta linea, convierte el array de primitivos en un array de objetos enteros.
         */

        Integer[] arrWrapper = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        /* Ya con el array de objetos enteros, podemos usar el metodo sort con el comparator que permite
        ordenar el arreglo de manera descendiente.
         */

        Arrays.sort(arrWrapper, Comparator.reverseOrder());

        /*
        Realizamos un bucle for, creamos una variable sum donde sumaremos alli todas las diferencias
        entre pares consecutivos y hacemos retorno a esta variable.
         */

        int sum = 0;
        for(int i = 0; i < arrWrapper.length - 1; i++){
            sum+= arrWrapper[i] - arrWrapper[i + 1];
        }
    return sum;}
}


