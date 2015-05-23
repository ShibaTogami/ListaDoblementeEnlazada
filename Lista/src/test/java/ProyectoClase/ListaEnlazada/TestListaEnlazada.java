package ProyectoClase.ListaEnlazada;

import static org.junit.Assert.*;

import org.junit.*;

public class TestListaEnlazada {

  public ListaEnlazada<Integer> l;
  public ListaEnlazada<Integer>.Nodo n;

  @Before
  public void init() {
    l = new ListaEnlazada<Integer>();
    n = l.new Nodo();
  }

  @After
  public void fin() {
    l = null;
    n = null;
  }

  /*********************** TESTS CORRESPONDIENTES A LA CLASE NODO ***********************/
  @Test
  public void crearNodoVacio() {
    ListaEnlazada<Integer>.Nodo nodoEsperado = l.new Nodo();

    n = l.new Nodo();

    assertEquals(nodoEsperado.obtenerDato(), n.obtenerDato());
  }

  @Test
  public void crearNodoConUnElementoNulo() {
    ListaEnlazada<Integer>.Nodo nodoEsperado = l.new Nodo(null);

    n = l.new Nodo(null);

    assertEquals(nodoEsperado.obtenerDato(), n.obtenerDato());
  }

  @Test
  public void crearNodoConUnElementoNoNulo() {
    int v = 14;
    ListaEnlazada<Integer>.Nodo nodoEsperado = l.new Nodo(v);

    n = l.new Nodo(v);

    assertEquals(nodoEsperado.obtenerDato(), n.obtenerDato());
  }

  @Test
  public void modificarDatoNuloDeUnNodoNoVacio() {
    int v = 14;
    ListaEnlazada<Integer>.Nodo nodoEsperado = l.new Nodo();

    n = l.new Nodo(v);
    n.modificarDato(null);

    assertEquals(nodoEsperado.obtenerDato(), n.obtenerDato());
  }

  @Test
  public void modificarDanoNoNuloDeUnNodoNoVacio() {
    int vinic = 14, vfin = 9;
    ListaEnlazada<Integer>.Nodo nodoEsperado = l.new Nodo(vfin);

    n = l.new Nodo(vinic);
    n.modificarDato(vfin);

    assertEquals(nodoEsperado.obtenerDato(), n.obtenerDato());
  }

  @Test
  public void modificarDatoNoNuloDeUnNodoVacio() {
    int v = 14;
    ListaEnlazada<Integer>.Nodo nodoEsperado = l.new Nodo(v);

    n = l.new Nodo();
    n.modificarDato(v);

    assertEquals(nodoEsperado.obtenerDato(), n.obtenerDato());
  }

  @Test
  public void obtenerDatoNodoVacio() {
    Integer valorEsperado = null;
    Integer valorDevuelto;

    n = l.new Nodo();
    valorDevuelto = n.obtenerDato();

    assertEquals(valorEsperado, valorDevuelto);
  }

  @Test
  public void obtenerDatoNodoNoVacio() {
    int v = 14;
    Integer valorEsperado = v;
    Integer valorDevuelto;


    n = l.new Nodo(v);
    valorDevuelto = n.obtenerDato();

    assertEquals(valorEsperado, valorDevuelto);
  }

  /*********************** TESTS CORRESPONDIENTES A LA CLASE LISTA ***********************/
  @Test
  public void crearListaVacia() {
    ListaEnlazada<Integer>.Nodo valorEsperado = null;

    l = new ListaEnlazada<Integer>();

    assertEquals(valorEsperado, l.obtenerPrimero());
    assertEquals(valorEsperado, l.obtenerUltimo());
  }

  @Test
  public void crearListaConValoresNulos() {
    ListaEnlazada<Integer>.Nodo valorEsperado = null;

    l = new ListaEnlazada<Integer>(null);

    assertEquals(valorEsperado, l.obtenerPrimero());
    assertEquals(valorEsperado, l.obtenerUltimo());
  }

  @Test
  public void crearListaConValoresNoNulos() {
    int v = 14;

    n = l.new Nodo(v);
    l = new ListaEnlazada<Integer>(n);

    assertEquals(n, l.obtenerPrimero());
    assertEquals(n, l.obtenerUltimo());
  }

  @Test(expected = ListaException.class)
  public void borrarNodoListaVacia() {
    int v = 14;

    n = l.new Nodo(v);
    l = new ListaEnlazada<Integer>();

    l.borrarNodo(n);

    fail("Aquí nunca debe llegar");
  }

  @Test
  public void borrarNodoListaConUnSoloElemento() {
    int v = 14;

    n = l.new Nodo(v);
    l = new ListaEnlazada<Integer>(n);

    l.borrarNodo(n);

    Integer valorEsperado = null;

    assertEquals(valorEsperado, l.obtenerPrimero());
    assertEquals(valorEsperado, l.obtenerUltimo());
  }

  @Test
  public void borrarNodoListaConVariosElementos() {
    int v = 14;

    n = l.new Nodo(14);
    l = new ListaEnlazada<Integer>(n);

    v = 9;
    ListaEnlazada<Integer>.Nodo n2 = l.new Nodo(v);
    v = 13;
    ListaEnlazada<Integer>.Nodo n3 = l.new Nodo(v);

    l.insertarUltimo(n2);
    l.insertarUltimo(n3);

    l.borrarNodo(n3);

    ListaEnlazada<Integer>.Nodo primeroEsperado = n;
    ListaEnlazada<Integer>.Nodo ultimoEsperado = n2;

    assertEquals(primeroEsperado, l.obtenerPrimero());
    assertEquals(ultimoEsperado, l.obtenerUltimo());
  }

  @Test
  public void insertarPrimeroNodoVacio(){
    ListaEnlazada<Integer> listaEsperada = l;
    
    n = l.new Nodo();
    l.insertarPrimero(n);

    assertEquals(listaEsperada.obtenerPrimero(), l.obtenerPrimero());
  }
  
  @Test
  public void insertarPrimeroNodoNoVacio(){
    ListaEnlazada<Integer> listaEsperada = l;
    int v = 14;
    
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo(v);
    n = l.new Nodo(v);
    
    listaEsperada.insertarPrimero(nodoAInsertar);
    l.insertarPrimero(n);
    
    assertEquals(listaEsperada.obtenerPrimero(), l.obtenerPrimero());
  }
  
  @Test
  public void insertarUltimoNodoVacio(){
    ListaEnlazada<Integer> listaEsperada = l;
    
    n = l.new Nodo();
    
    l.insertarUltimo(n);
    
    assertEquals(listaEsperada.obtenerUltimo(), l.obtenerUltimo());
  }
  
  @Test
  public void insertarUltimoNodoNoVacio(){
    ListaEnlazada<Integer> listaEsperada = l;
    int v = 14;
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo(v);
    n = l.new Nodo(v);
    
    listaEsperada.insertarUltimo(nodoAInsertar);
    l.insertarUltimo(n);
    
    assertEquals(listaEsperada.obtenerUltimo(), l.obtenerUltimo());
  }
  
  

}
