
public class reversePositionWords{
    public String reverseWords(String s){

        /*
         Se utiliza el metodo split de la clase String para separar la cadena S en un array de
         strings. Cada elemento del arreglo es una palabra individual en el String S. Se usa una
         expresion regular "\\." como separador para poder identificar donde se separa cada palabra.
         */

        String[]words=s.split("\\.");

        // Se crea un objeto StringBuilder para poder usar concatenacion de strings.

        StringBuilder sb=new StringBuilder();

        // Bucle for que va a iterar sobre el arreglo de palabras de manera inversa, del ultimo al primero.

        for(int i=words.length-1;i>=0;i--){

            // En cada iteracion, se concatena el elemento actual al arreglo words.

            sb.append(words[i]);

            // Si hay mas de una palabra, se agrega un punto para separarla de la siguiente.

            if(i>0){
                sb.append(".");
            }
        }

        /*
        Devolvemos el resultado como una string, utilizando el metodo 'toString' del objeto StringBuilder
         */


        return sb.toString();
    }
}


