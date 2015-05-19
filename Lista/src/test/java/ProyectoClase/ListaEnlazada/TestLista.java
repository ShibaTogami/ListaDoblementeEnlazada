/*
 * Test casuístico para la lista doblemente enlazada. Dentro del test hay una línea que provoca una
 * excepción. Si se desea continuar hasta el final basta con comentarla (línea 59).
 * La traza viene dada en un archivo logger llamado logging.xml que aparece en la raiz del proyeto
 * cuando se ejecuta la traza. 
 */
package ProyectoClase.ListaEnlazada;

import java.io.IOException;
import java.util.Random;
import java.util.logging.*;

import ProyectoClase.ListaEnlazada.ListaEnlazada.Nodo;

public class TestLista {

  private TestLista() {

  }

  public static void main(String[] args) {
    // Obtenemos Logger para traza
    final Logger LOGGER = Logger.getLogger("ProyectoClase.ListaEnlazada.TestLista");
    LOGGER.setLevel(Level.FINE);
    FileHandler fileXml;
    try {
      fileXml = new FileHandler("Logging.xml");
      LOGGER.addHandler(fileXml);
    } catch (SecurityException e) {
      LOGGER.throwing("TestLista","Constructor FileHandler" , e);
    } catch (IOException e) {  
      LOGGER.throwing("TestLista","Constructor FileHandler" , e);
    }

    // creamos una lista vacia
    ListaEnlazada<Integer> listaprueba = new ListaEnlazada<Integer>();
    // el siguiente println debería mostrar lista vacia
    LOGGER.fine(listaprueba.toString());
    // creamos una lista nueva con un 7
    Nodo nodo = listaprueba.new Nodo(7);
    listaprueba = new ListaEnlazada<Integer>(nodo);
    // el siguiente println debería mostrar el 7
    LOGGER.fine(listaprueba.toString());
    // probaremos a añadir 4 numeros aleatorios antes del 7
    Random semilla = new Random();
    int numero;
    for (int i = 0; i < 4; i++) {
      numero = semilla.nextInt(10);
      LOGGER.fine((i + 1) + "º numero:" + numero + "\n");
      listaprueba.insertarAntes(listaprueba.obtenerPrimero(), listaprueba.new Nodo(numero));
    }
    LOGGER.fine(listaprueba.toString());
    // probaremos a intercalar ahora uno antes del 7
    listaprueba.insertarAntes(listaprueba.obtenerUltimo(),
        listaprueba.new Nodo(semilla.nextInt(10)));
    LOGGER.fine(listaprueba.toString());
    // probamos a insertar antes de un nodo que no existe debería saltar una expceción, para
    //----> continuar el test comentar la siguiente línea. <------
    listaprueba.insertarAntes(listaprueba.new Nodo(22), listaprueba.new Nodo(semilla.nextInt(10)));
    LOGGER.fine(listaprueba.toString());
    // probamos el método insertarPrimero.
    listaprueba.insertarPrimero(listaprueba.new Nodo(5));
    LOGGER.fine(listaprueba.toString());
    // vaciamos la lista para probar a insertar despues de un nodo
    listaprueba = new ListaEnlazada<Integer>();
    LOGGER.fine(listaprueba.toString());
    // insertamos un nodo de control con un 5
    listaprueba.insertarPrimero(listaprueba.new Nodo(5));
    LOGGER.fine(listaprueba.toString());
    for (int i = 0; i < 4; i++) {
      numero = semilla.nextInt(10);
      LOGGER.fine((i + 1) + "º numero:" + numero + "\n");
      listaprueba.insertarDespues(listaprueba.obtenerPrimero(), listaprueba.new Nodo(numero));
    }
    LOGGER.fine(listaprueba.toString());
    // probamos a insertar un numero alto al final de la lista
    listaprueba.insertarDespues(listaprueba.obtenerUltimo(), listaprueba.new Nodo(22));
    LOGGER.fine(listaprueba.toString());
    // probamos a intercalar un numero alto antes del último elemento.
    listaprueba.insertarAntes(listaprueba.obtenerUltimo(), listaprueba.new Nodo(21));
    LOGGER.fine(listaprueba.toString());
    // borramos todos los nodos hasta dejarlos vacia
    for (int i = 0; i < 7; i++) {
      listaprueba.borrarNodo(listaprueba.obtenerPrimero());
      LOGGER.fine(listaprueba.toString());
    }
    // insertamos numeros ordenados para pasara a una eliminación en un orden concreto
    Nodo nodo1 = listaprueba.new Nodo(1);
    Nodo nodo2 = listaprueba.new Nodo(2);
    Nodo nodo3 = listaprueba.new Nodo(3);
    Nodo nodo4 = listaprueba.new Nodo(4);
    Nodo nodo5 = listaprueba.new Nodo(5);
    listaprueba.insertarPrimero(nodo5);
    listaprueba.insertarPrimero(nodo4);
    listaprueba.insertarPrimero(nodo3);
    listaprueba.insertarPrimero(nodo2);
    listaprueba.insertarPrimero(nodo1);

    LOGGER.fine(listaprueba.toString());

    // borramos primer nodo
    listaprueba.borrarNodo(nodo1);
    // borramos el ultimo
    listaprueba.borrarNodo(nodo5);
    // borramos el del medio
    listaprueba.borrarNodo(nodo3);

    LOGGER.fine(listaprueba.toString());
  }

}
