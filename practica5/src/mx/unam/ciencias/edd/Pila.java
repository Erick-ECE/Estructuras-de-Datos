package mx.unam.ciencias.edd;

/**
 * Clase para pilas genéricas.
 */
public class Pila<T> extends MeteSaca<T> {

    /**
     * Agrega un elemento al tope de la pila.
     * @param elemento el elemento a agregar.
     */
    @Override public void mete(T elemento) {
        // Aquí va su código.
        if (elemento == null)
            throw new IllegalArgumentException("Elemento nulo.");
        Nodo nodo = new Nodo(elemento);
        if (cabeza == null) {
            cabeza = rabo = nodo;
        } else {
            nodo.siguiente = cabeza;
            cabeza = nodo;
        }
    }
}
