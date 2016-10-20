package mx.unam.ciencias.edd;

import java.util.Iterator;

/**
 * <p>Clase para árboles binarios ordenados. Los árboles son genéricos, pero
 * acotados a la interfaz {@link Comparable}.</p>
 *
 * <p>Un árbol instancia de esta clase siempre cumple que:</p>
 * <ul>
 *   <li>Cualquier elemento en el árbol es mayor o igual que todos sus
 *       descendientes por la izquierda.</li>
 *   <li>Cualquier elemento en el árbol es menor o igual que todos sus
 *       descendientes por la derecha.</li>
 * </ul>
 */
public class ArbolBinarioOrdenado<T extends Comparable<T>>
    extends ArbolBinario<T> {

    /* Clase privada para iteradores de árboles binarios ordenados. */
    private class Iterador implements Iterator<T> {

        /* Pila para emular la pila de ejecución. */
        private Pila<ArbolBinario<T>.Vertice> pila;

        /* Construye un iterador con el vértice recibido. */
        public Iterador() {
            // Aquí va su código
            pila = new Pila<ArbolBinario<T>.Vertice>();
            itera(raiz);
        }
        private void itera(Vertice v){
          if(v==null)
            return;
          itera(v.derecho);
          pila.mete(v);
          itera(v.izquierdo);
        }

        /* Nos dice si hay un siguiente elemento. */
        @Override public boolean hasNext() {
            // Aquí va su código.
            return !pila.esVacia();
        }

        /* Regresa el siguiente elemento del árbol en orden. */
        @Override public T next() {
            // Aquí va su código.
            Vertice v = pila.saca();
            if (v.hayDerecho()) {
              Vertice  vi = v.derecho;
                while(vi != null){
                    pila.mete(vi);
                    vi = vi.izquierdo;
                }
            }
            return v.elemento;
        }

        /* No lo implementamos: siempre lanza una excepción. */
        @Override public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Constructor sin parámetros. Para no perder el constructor sin parámetros
     * de {@link ArbolBinario}.
     */
    public ArbolBinarioOrdenado() { super(); }

    /**
     * Construye un árbol binario ordenado a partir de una colección. El árbol
     * binario ordenado tiene los mismos elementos que la colección recibida.
     * @param coleccion la colección a partir de la cual creamos el árbol
     *        binario ordenado.
     */
    public ArbolBinarioOrdenado(Coleccion<T> coleccion) {
        super(coleccion);
    }

    /**
     * Agrega un nuevo elemento al árbol. El árbol conserva su orden in-order.
     * @param elemento el elemento a agregar.
     */
    @Override public void agrega(T elemento) {
        // Aquí va su código.
      Vertice a= nuevoVertice(elemento);
      agrega(a,raiz);
    }
    private void agrega(Vertice nuevo,Vertice piv){
      if(piv==null)
        piv=nuevo;
      if(nuevo.elemento.compareTo(piv.elemento) <= 0){
        if (piv.hayIzquierdo() == false) {
          piv.izquierdo=nuevo;
          nuevo.padre=piv;
          this.ultimoAgregado=nuevo;
        }else agrega(nuevo,piv.izquierdo);

      }else if(piv.hayDerecho() == false){
          piv.derecho= nuevo;
          nuevo.padre=piv;
          this.ultimoAgregado=nuevo;
        }else{
        agrega(nuevo,piv.derecho);
      }
      elementos++;
      }


    /**
     * Elimina un elemento. Si el elemento no está en el árbol, no hace nada; si
     * está varias veces, elimina el primero que encuentre (in-order). El árbol
     * conserva su orden in-order.
     * @param elemento el elemento a eliminar.
     */
    @Override public void elimina(T elemento) {
        // Aquí va su código.
        Vertice eliminar = this.busca(this.raiz, elemento), vi;
       if (eliminar == null) {
           return;
       }
       if (eliminar.hayIzquierdo()) {
           vi = eliminar;
           eliminar = maximoEnSubarbol(eliminar.izquierdo);
           vi.elemento = eliminar.elemento;
       }

       if (!eliminar.hayIzquierdo() && !eliminar.hayDerecho()) {
           this.ehoja(eliminar);
       } else if (!eliminar.hayIzquierdo()) {
           this.eIzquierdo(eliminar);
       } else {
           this.eDerecho(eliminar);
       }
    }

    /**
     * Busca recursivamente un elemento, a partir del vértice recibido.
     * @param vertice el vértice a partir del cuál comenzar la búsqueda. Puede
     *                ser <code>null</code>.
     * @param elemento el elemento a buscar a partir del vértice.
     * @return el vértice que contiene el elemento a buscar, si se encuentra en
     *         el árbol; <code>null</code> en otro caso.
     */
    @Override protected Vertice busca(Vertice vertice, T elemento) {
        // Aquí va su código.
        Vertice iz;
       if (vertice == null)
           return null;
       iz = this.busca(vertice.izquierdo, elemento);
       if (iz != null) {
           return iz;
       }
       if (vertice.elemento.equals(elemento)) {
           return vertice;
       }
       return this.busca(vertice.derecho, elemento);
    }

    /**
     * Regresa el vértice máximo en el subárbol cuya raíz es el vértice que
     * recibe.
     * @param vertice el vértice raíz del subárbol del que queremos encontrar el
     *                máximo.
     * @return el vértice máximo el subárbol cuya raíz es el vértice que recibe.
     */
    protected Vertice maximoEnSubarbol(Vertice vertice) {
        // Aquí va su código.
        return  vertice;
    }

    /**
     * Regresa un iterador para iterar el árbol. El árbol se itera en orden.
     * @return un iterador para iterar el árbol.
     */
    @Override public Iterator<T> iterator() {
        return new Iterador();
    }

    /**
     * Gira el árbol a la derecha sobre el vértice recibido. Si el vértice no
     * tiene hijo izquierdo, el método no hace nada.
     * @param vertice el vértice sobre el que vamos a girar.
     */
    public void giraDerecha(VerticeArbolBinario<T> vertice) {
        // Aquí va su código.
        if(vertice.getIzquierdo()== null)
          return;
    }

    /**
     * Gira el árbol a la izquierda sobre el vértice recibido. Si el vértice no
     * tiene hijo derecho, el método no hace nada.
     * @param vertice el vértice sobre el que vamos a girar.
     */
    public void giraIzquierda(VerticeArbolBinario<T> vertice) {
        // Aquí va su código.
        Vertice ver=vertice(vertice);
        if(ver.izquierdo==null)
          return;
        Vertice tice=ver.izquierdo;
        tice.padre=ver.padre;
        if(ver.padre!=null)
            if(ver.padre.derecho==ver)
              ver.padre.derecho=tice;
            else
              ver.padre.izquierdo=tice;
          else
            raiz=tice;
          ver.izquierdo=tice.derecho;
          if(tice.derecho!=null)
            tice.derecho.padre=ver;
          tice.derecho=ver;
          ver.padre=tice;
    }

    private void ehoja(Vertice eliminar) {
       if (raiz == eliminar) {
           raiz = null;
           ultimoAgregado = null;
       } else if (izquierdo(eliminar))
           eliminar.padre.izquierdo = null;
      eliminar.padre.derecho = null;

       this.elementos--;
   }


   private void eIzquierdo(Vertice eliminar) {
       if (raiz == eliminar) {
           raiz = raiz.derecho;
           eliminar.derecho.padre = null;
       } else {
           eliminar.derecho.padre = eliminar.padre;
           if (izquierdo(eliminar)) {
               eliminar.padre.izquierdo = eliminar.derecho;
           } else {
               eliminar.padre.derecho = eliminar.derecho;
           }
       }
       this.elementos--;
   }


   private void eDerecho(Vertice eliminar) {
       if (raiz == eliminar) {
           raiz = raiz.izquierdo;
           eliminar.izquierdo.padre = null;
       } else {
           eliminar.izquierdo.padre = eliminar.padre;
           if (izquierdo(eliminar))
               eliminar.padre.izquierdo = eliminar.izquierdo;
          eliminar.padre.derecho = eliminar.izquierdo;

       }
       elementos--;
   }

   private boolean izquierdo(Vertice v) {
       if (!v.hayPadre())
           return false;

       return v.padre.izquierdo == v;
   }

   private boolean derecho(Vertice v) {
       if (!v.hayPadre()) {
           return false;
       }
       return v.padre.derecho == v;
   }
}
