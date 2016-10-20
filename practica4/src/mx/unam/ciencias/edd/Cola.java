package mx.unam.ciencias.edd;

/**
 * Clase para colas genéricas.
 */
public class Cola<T> extends MeteSaca<T> {

    /**
     * Agrega un elemento al final de la cola.
     * @param elemento el elemento a agregar.
     */
    @Override public void mete(T elemento) {
        // Aquí va su código.
          if (elemento == null)
            throw new IllegalArgumentException("Elemento nulo.");
        Nodo nodo = new Nodo(elemento);
        if (rabo == null) {
            cabeza = rabo = nodo;
        } else {
            rabo.siguiente = nodo;
            rabo = nodo;
        }
    }
}
