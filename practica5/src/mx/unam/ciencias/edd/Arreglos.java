package mx.unam.ciencias.edd;

/**
 * Clase para manipular arreglos genéricos de elementos comparables.
 */
public class Arreglos {
    //metodo auixiliar
    public static <T extends Comparable<T>>
    void intercambia(T[] a, int i, int j){
        if(i==j)
            return;
        T t= a[j];
        a[j]= a[i];
        a[i]= t;
    }

    /**
     * Ordena el arreglo recibido usando QickSort.
     * @param <T> tipo del que puede ser el arreglo.
     * @param a un arreglo cuyos elementos son comparables.
     */
    public static <T extends Comparable<T>> void quickSort(T[] a) {
        // Aquí va su código.
        int ini=0;
      int fin = a.length - 1;
      quicksort(a, ini, fin);

    }
    private static <T extends Comparable<T>>
    void quicksort(T[] a, int ini, int fin) {
      if(fin <= ini){
        return;
    }
      int i = ini + 1;
      int j = fin;
      while(i < j) {
        if(a[i].compareTo(a[ini]) > 0 && a[j].compareTo(a[ini]) <= 0){
          intercambia(a, i++, j--);
      }
        else if(a[i].compareTo(a[ini]) <= 0){
          i++;
      }
        else
          j--;
      }
      if(a[i].compareTo(a[ini]) > 0){
        i--;
    }
      intercambia(a, ini, i);
      quicksort(a, ini, i - 1);
      quicksort(a, i + 1, fin);
    }
    

    /**
     * Ordena el arreglo recibido usando SelectionSort.
     * @param <T> tipo del que puede ser el arreglo.
     * @param a un arreglo cuyos elementos son comparables.
     */
    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        // Aquí va su código.
         for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                  if (a[j].compareTo(a[min]) < 0)
                        min = j;
            if (min != i) {
               intercambia(a,min,i);
            }
      }

        }
    

    /**
     * Hace una búsqueda binaria del elemento en el arreglo. Regresa el índice
     * del elemento en el arreglo, o -1 si no se encuentra.
     * @param <T> tipo del que puede ser el arreglo.
     * @param a el arreglo dónde buscar.
     * @param e el elemento a buscar.
     * @return el índice del elemento en el arreglo, o -1 si no se encuentra.
     */
    public static <T extends Comparable<T>> int busquedaBinaria(T[] a, T e) {
       int j=0;
        for (T n : a) {
            if(n.equals(e))
                return j;
            j+= 1;
        }
        return -1;
    }
}
