package ProyectoClase.ListaEnlazada;

public class ListaEnlazada<T> // Implementa una lista con nodos de datos de tipo T
{
  private Nodo primero; // Nodo inicial de la lista
  private Nodo ultimo; // Nodo final

  public class Nodo // clase interna nodo que define cada nodo de la lista
  {
    private Nodo siguiente; // enlace al siguiente nodo
    private Nodo previo; // enlace al nodo anterior
    private T dato; // dato que contiene el nodo.

    // constructor
    public Nodo() // devuelve un nodo vacio
    {
      siguiente = null;
      previo = null;
      this.dato = null;
    }

    public Nodo(T dato) // devuelve un nodo con un dato en su interior
    {
      siguiente = null;
      previo = null;
      this.dato = dato;

    }

    // métodos

    public T obtenerDato() // obtiene el dato de un nodo
    {
      return dato;
    }

    public void modificarDato(T nuevodato)// cambia el contenido de un nodo
    {
      this.dato = nuevodato;
    }

    @Override
    public String toString() {
      return dato.toString();
    }
  }

  // constructores de lista
  public ListaEnlazada() // creación de la lista vacia
  {
    this.primero = null;
    this.ultimo = null;
  }

  public ListaEnlazada(Nodo nodo) // creación de lista con su primer nodo
  {
    this.primero = nodo;
    this.ultimo = nodo;
  }

  // métodos
  public Nodo obtenerPrimero() {
    return primero;
  }

  public Nodo obtenerUltimo() {
    return ultimo;
  }

  public void insertarAntes(Nodo buscado, Nodo nodoAInsertar) // esté método inserta un nodo en la
                                                              // lista justo antes del nodo
                                                              // especificado
  {
    if (this.primero == null) { // si la lista está vacia
      throw new ListaException("La lista está vacia.");
    } else {
      Nodo auxiliar = this.primero; // nodo auxiliar apuntando al primer elemento
      if (!auxiliar.equals(buscado)) // mientras ese primer nodo auxiliar no sea el que buscamos...
      {
        while (auxiliar.siguiente != null && !auxiliar.siguiente.equals(buscado))// avanzamos en
                                                                                   // la
                                                                                   // lista
        // hasta que demos con un nodo, cuyo siguiente es el que buscamos (o demos con el final)
        {
          auxiliar = auxiliar.siguiente;
        }// al salir del bucle habremos encontrado el nodo anterior al buscado, o el final de la
         // lista
        if (auxiliar.siguiente == null)// si es el final
        {
          throw new ListaException("El nodo especificado no se encuentra en la lista");
        } else // si no pasamos a insertar el nodo
        {
          auxiliar.siguiente.previo = nodoAInsertar;
          nodoAInsertar.siguiente = auxiliar.siguiente; // el nodo buscado pasa a ser el siguiente
                                                        // del
                                                        // insertado
          nodoAInsertar.previo = auxiliar;
          auxiliar.siguiente = nodoAInsertar; // el nodo insertado pasa a ser el anterior al buscado

        }
      } else // si da la casualidad de que ese primer nodo es el que buscamos
      {

        auxiliar.previo = nodoAInsertar; // indicamos que antes del nodo encontrado va este nuevo
                                         // nodo
        nodoAInsertar.siguiente = auxiliar; // indicamos que despues del nodo a insertar va este
                                            // primero
        nodoAInsertar.previo = null; // indicamos que este es el primer nodo.
        this.primero = nodoAInsertar; // ponemos como primer nodo de la lista este nuevo.

      }
    }
  }

  public void insertarDespues(Nodo buscado, Nodo nodoAInsertar) {
    Nodo auxiliar = this.obtenerPrimero();
    if (this.primero == null) { // si la lista está vacia
      throw new ListaException("Lista está vacia.");
    } else {
      while (auxiliar.siguiente != null && !auxiliar.equals(buscado)) // mientras no sea el final de
      // la cola y no hayamos encontrado el nodo que buscamos
      {
        auxiliar = auxiliar.siguiente;
      }// al salir de este bucle puede ser que hayamos llegado al final de la lista
       // o que hayamos encontrado el nodo que deseamos buscar.
      if (auxiliar.equals(buscado) && auxiliar.siguiente != null) // si es el nodo que buscabamos y
                                                                  // hay nodos por delante
      {
        nodoAInsertar.siguiente = auxiliar.siguiente;
        auxiliar.siguiente.previo = nodoAInsertar;
        auxiliar.siguiente = nodoAInsertar;
        nodoAInsertar.previo = auxiliar;
      } else if (auxiliar.equals(buscado) && auxiliar.siguiente == null) // si es el nodo que
      // buscamos pero ES el último
      {
        nodoAInsertar.siguiente = auxiliar.siguiente;
        auxiliar.siguiente = nodoAInsertar;
        nodoAInsertar.previo = auxiliar;
        this.ultimo = nodoAInsertar;
      } else // significaría que llegamos al final de la lista
      {
        throw new ListaException("El nodo especificado no se encuentra en la lista");
      }
    }
  }

  public void insertarPrimero(Nodo nodoAInsertar) // inserta un nodo en la primera posición de la
                                                  // lista.
  {
    if (this.primero == null) { // si la lista esta vacía
      this.primero = nodoAInsertar;
      this.ultimo = nodoAInsertar;
    } else { // si ya hay algun elemento
      this.insertarAntes(this.primero, nodoAInsertar);
    }
  }

  public void insertarUltimo(Nodo nodoAInsertar) // inserta un nodo en la última posición de la
  // lista.
  {
    if (this.primero == null) { // si la lista esta vacía
      this.primero = nodoAInsertar;
      this.ultimo = nodoAInsertar;
    } else { // si ya hay algun elemento
      this.insertarDespues(this.ultimo, nodoAInsertar);
    }
  }


  public void borrarNodo(Nodo nodo) // elimina el nodo en la lista que se la ha pasado como
                                    // parametro.
  {
    if (this.primero == null) // si la lista está vacia
    {
      throw new ListaException("Lista Vacia, no puede borrarse ningun nodo.");
    } else { //en caso contrario
      Nodo auxiliar = this.primero;
      while (auxiliar != null && !auxiliar.equals(nodo)){ // mientras no encontremos el nodo deseado
      // y haya elementos en la lista avanzamos por la lista
        auxiliar = auxiliar.siguiente;
      } // cuando salgamos de este bucle habremos encontrado el nodo a borrar o el final de la lista
      if (auxiliar == null) // si hemos llegado al final
      {
        throw new ListaException("No se encuentra el nodo que se desea borrar.");
      } else {
        borrarNodoLocalizado(auxiliar);
      }
    }

  }
  
  private void borrarNodoLocalizado(Nodo nodo){ //Esté metodo tiene como argumento el nodo a borrar
    //con la diferencia de que se salta las comprobacioens previas, eso se comprueba en el método
    //borrarNodo. Esta decisión de hacerlo por separado se ha tomado con el objetivo de reducir
    //la complejidad ciclomática.
    if (nodo.equals(primero)&&nodo.equals(ultimo)){ //es el único nodo de la lista.
      this.primero = null; // dejamos la lista como vacia
      this.ultimo = null;
    }
    else if (nodo.equals(primero)&&!nodo.equals(ultimo)){ //es el primer nodo de varios.
      nodo.siguiente.previo = null;
      this.primero = nodo.siguiente;// establecemos el segundo nodo como el primero de la
                                    // lista
    }else if (!nodo.equals(primero) && nodo.equals(ultimo)) {
      // es el último nodo
      nodo.previo.siguiente = null; //terminamos la lista en el nodo anterior
      this.ultimo = nodo.previo; // establecemos el nodo anterior como el ultimo.
    } else if (!nodo.equals(primero) && !nodo.equals(ultimo)) {
      // si encontramos el nodo y es intermedio
      nodo.previo.siguiente = nodo.siguiente;
      nodo.siguiente.previo = nodo.previo; // aislamos el nodo de la lista y lo hacemos
                                                   // inaccesible
    }
    
  }

  @Override
  public String toString() // método creado para visualizar los elementos de la lista
  {
    String salida = ""; // cadena de salida del método
    if (primero == null) // si la lista esta vacia
    {
      salida = "Lista Vacia.";
    } else if (this.primero == this.ultimo) // si hay sólo un elemento
    {
      salida = primero.toString();
    } else // si hay mas de un elementos
    {
      Nodo auxiliar = this.primero; // creamos un nodo auxiliar
      salida = salida + auxiliar.toString(); // metemos en la salida su representación
      while (auxiliar.siguiente != null) // mientras haya más elementos
      {
        auxiliar = auxiliar.siguiente; // pasamos al siguiente nodo
        salida = salida + ", " + auxiliar.toString(); // añadimos su representación a la cadena de
                                                      // salida
      }
    }
    return salida;
  }


}
