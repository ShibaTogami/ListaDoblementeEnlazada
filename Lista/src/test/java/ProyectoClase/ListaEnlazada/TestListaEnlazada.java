package ProyectoClase.ListaEnlazada;

/************************** Author: Rocío Arrebola Pascual **************************/

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
    ListaEnlazada<Integer> valorEsperado = new ListaEnlazada<Integer>();

    l = new ListaEnlazada<Integer>();

    assertEquals(valorEsperado.toString(), l.toString());
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
    ListaEnlazada<Integer> listaEsperada;
    ListaEnlazada<Integer>.Nodo nodoInicial = l.new Nodo(v);
    
    listaEsperada = new ListaEnlazada<Integer>(nodoInicial);
    
    n = l.new Nodo(v);
    l = new ListaEnlazada<Integer>(n);

    assertEquals(listaEsperada.toString(), l.toString());
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

    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>();

    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test
  public void borrarPrimerNodoListaConVariosElementos() {
    int v = 14;
    
    n = l.new Nodo(14);
    l = new ListaEnlazada<Integer>(n);

    ListaEnlazada<Integer>.Nodo nodoAInsertar1 = l.new Nodo(v);
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(nodoAInsertar1);
    
    v = 9;
    ListaEnlazada<Integer>.Nodo n2 = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo nodoAInsertar2 = l.new Nodo(v);
    v = 13;
    ListaEnlazada<Integer>.Nodo n3 = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo nodoAInsertar3 = l.new Nodo(v);

    l.insertarUltimo(n2);
    l.insertarUltimo(n3);
    
    listaEsperada.insertarUltimo(nodoAInsertar2);
    listaEsperada.insertarUltimo(nodoAInsertar3);

    l.borrarNodo(n);
    listaEsperada.borrarNodo(nodoAInsertar1);

    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test
  public void borrarNodoIntermedioListaConVariosElementos() {
    int v = 14;
    
    n = l.new Nodo(14);
    l = new ListaEnlazada<Integer>(n);

    ListaEnlazada<Integer>.Nodo nodoAInsertar1 = l.new Nodo(v);
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(nodoAInsertar1);
    
    v = 9;
    ListaEnlazada<Integer>.Nodo n2 = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo nodoAInsertar2 = l.new Nodo(v);
    v = 13;
    ListaEnlazada<Integer>.Nodo n3 = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo nodoAInsertar3 = l.new Nodo(v);

    l.insertarUltimo(n2);
    l.insertarUltimo(n3);
    
    listaEsperada.insertarUltimo(nodoAInsertar2);
    listaEsperada.insertarUltimo(nodoAInsertar3);

    l.borrarNodo(n2);
    listaEsperada.borrarNodo(nodoAInsertar2);

    assertEquals(listaEsperada.toString(), l.toString());
  }

  @Test
  public void borrarUltimoNodoListaConVariosElementos() {
    int v = 14;
    
    n = l.new Nodo(14);
    l = new ListaEnlazada<Integer>(n);

    ListaEnlazada<Integer>.Nodo nodoAInsertar1 = l.new Nodo(v);
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(nodoAInsertar1);
    
    v = 9;
    ListaEnlazada<Integer>.Nodo n2 = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo nodoAInsertar2 = l.new Nodo(v);
    v = 13;
    ListaEnlazada<Integer>.Nodo n3 = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo nodoAInsertar3 = l.new Nodo(v);

    l.insertarUltimo(n2);
    l.insertarUltimo(n3);
    
    listaEsperada.insertarUltimo(nodoAInsertar2);
    listaEsperada.insertarUltimo(nodoAInsertar3);

    l.borrarNodo(n3);
    listaEsperada.borrarNodo(nodoAInsertar3);

    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test (expected = ListaException.class)
  public void borrarNodoNoExiste(){
    int v = 14;
    
    n = l.new Nodo(14);
    l = new ListaEnlazada<Integer>(n);

    ListaEnlazada<Integer>.Nodo nodoAInsertar1 = l.new Nodo(v);
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(nodoAInsertar1);
    
    v = 9;
    ListaEnlazada<Integer>.Nodo n2 = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo nodoAInsertar2 = l.new Nodo(v);
    v = 13;
    ListaEnlazada<Integer>.Nodo n3 = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo nodoAInsertar3 = l.new Nodo(v);

    l.insertarUltimo(n2);
    l.insertarUltimo(n3);
    
    listaEsperada.insertarUltimo(nodoAInsertar2);
    listaEsperada.insertarUltimo(nodoAInsertar3);
    
    v = 7;
    ListaEnlazada<Integer>.Nodo nodoABorrarEsperado = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo nodoABorrar = l.new Nodo(v);
    
    listaEsperada.borrarNodo(nodoABorrarEsperado);
    fail("Aquí nunca debe llegar");
    l.borrarNodo(nodoABorrar);
    
  }

  @Test
  public void insertarPrimeroNodoVacioListaVacia(){
    ListaEnlazada<Integer>.Nodo nodoEsperado = l.new Nodo();
    
    n = l.new Nodo();
    l.insertarPrimero(n);

    assertEquals(nodoEsperado.toString(), l.obtenerPrimero().toString());
  }
  
  @Test
  public void insertarPrimeroNodoNoVacioListaVacia(){
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>();
    int v = 14;
    
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo(v);
    n = l.new Nodo(v);
    
    listaEsperada.insertarPrimero(nodoAInsertar);
    l.insertarPrimero(n);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test
  public void insertarPrimeroNodoVacioListaUnElemento(){
    int v = 14;
    ListaEnlazada<Integer>.Nodo nodoPrimero = l.new Nodo(v);
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(nodoPrimero);
    l = new ListaEnlazada<Integer>(nodoPrimero);
    
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo();
    n = l.new Nodo();
    
    listaEsperada.insertarPrimero(nodoAInsertar);
    l.insertarPrimero(n);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test
  public void insertarPrimeroNodoNoVacioListaUnElemento(){
    int v = 14;
    ListaEnlazada<Integer>.Nodo nodoPrimero = l.new Nodo(v);
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(nodoPrimero);
    l = new ListaEnlazada<Integer>(nodoPrimero);
    
    v = 9;
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo(v);
    n = l.new Nodo(v);
    
    listaEsperada.insertarPrimero(nodoAInsertar);
    l.insertarPrimero(n);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test
  public void insertarUltimoNodoVacioListaVacia(){
    ListaEnlazada<Integer>.Nodo nodoEsperado = l.new Nodo();
    
    n = l.new Nodo();
    
    l.insertarUltimo(n);
    
    assertEquals(nodoEsperado.toString(), l.obtenerUltimo().toString());
  }
  
  @Test
  public void insertarUltimoNodoNoVacioListaVacia(){
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>();
    int v = 14;
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo(v);
    n = l.new Nodo(v);
    
    listaEsperada.insertarUltimo(nodoAInsertar);
    l.insertarUltimo(n);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test
  public void insertarUltimoNodoVacioListaUnElemento(){
    int v = 14;
    ListaEnlazada<Integer>.Nodo nodoPrimero = l.new Nodo(v);
    n = l.new Nodo(v);
    
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer> (nodoPrimero);
    l = new ListaEnlazada<Integer>(n);
    
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo();
    
    l.insertarUltimo(nodoAInsertar);
    listaEsperada.insertarUltimo(nodoAInsertar);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test
  public void insertarUltimoNodoNoVacioListaUnElemento(){
    int v = 14;
    ListaEnlazada<Integer>.Nodo nodoPrimero = l.new Nodo(v);
    n = l.new Nodo(v);
    
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer> (nodoPrimero);
    l = new ListaEnlazada<Integer>(n);
    
    v = 9;
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo(v);
    
    l.insertarUltimo(nodoAInsertar);
    listaEsperada.insertarUltimo(nodoAInsertar);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }

/************* REVISAR TEST *************/
  /*@Test
  public void insertarUltimoNodoVacioListaVariosElementos(){
    int v = 14;
    ListaEnlazada<Integer>.Nodo nodoPrimero = l.new Nodo(v);
    n = l.new Nodo(v);
    
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer> (nodoPrimero);
    l = new ListaEnlazada<Integer>(n);
    
    v = 9;
    ListaEnlazada<Integer>.Nodo n2 = l.new Nodo(v);
    
    l.insertarPrimero(n2);
    listaEsperada.insertarPrimero(n2);
    
    v = 2;
    ListaEnlazada<Integer>.Nodo n3 = l.new Nodo(v);
    l.insertarPrimero(n3);
    listaEsperada.insertarPrimero(n3);
    
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo();
    l.insertarUltimo(nodoAInsertar);
    listaEsperada.insertarUltimo(nodoAInsertar);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }*/

  /************* REVISAR TEST *************/
  @Test
  public void insertarUltimoNodoNoVacioListaVariosElementos(){
    int v = 14;
    ListaEnlazada<Integer>.Nodo nodoPrimero = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo nodoPrimeroEsperado = l.new Nodo(v);
    
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer> (nodoPrimeroEsperado);
    l = new ListaEnlazada<Integer>(nodoPrimero);
    
    v = 9;
    ListaEnlazada<Integer>.Nodo n2 = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo n2Esperado = l.new Nodo(v);
    
    l.insertarPrimero(n2);
    listaEsperada.insertarPrimero(n2Esperado);
    
    v = 2;
    ListaEnlazada<Integer>.Nodo n3 = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo n3Esperado = l.new Nodo(v);
    
    l.insertarPrimero(n3);
    listaEsperada.insertarPrimero(n3Esperado);
    
    v = 45;
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo(v);
    n = l.new Nodo(v);
    
    l.insertarUltimo(nodoAInsertar);
    listaEsperada.insertarUltimo(n);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test (expected = ListaException.class)
  public void insertarAntesListaVacía(){
    int v = 14;
    
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo(v);
    
    l.insertarAntes(l.obtenerPrimero(), nodoAInsertar);
    
    fail("Aquí nunca debe llegar");
  }
  
  @Test
  public void insertarAntesElementoVacíoListaDeUnSoloElemento(){
    int v = 14;
    ListaEnlazada<Integer>.Nodo primerNodoEsperado = l.new Nodo(v);
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(primerNodoEsperado);
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo();
    
    l = new ListaEnlazada<Integer>(primerNodoEsperado);
    l.insertarAntes(l.obtenerPrimero(), n);
    listaEsperada.insertarAntes(primerNodoEsperado, nodoAInsertar);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test
  public void insertarAntesElementoNoVacíoListaDeUnSoloElemento(){
    int v = 14;
    ListaEnlazada<Integer>.Nodo primerNodoEsperado = l.new Nodo(v);
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(primerNodoEsperado);
    v = 9;
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo(v);
    n = l.new Nodo(v);
    
    l = new ListaEnlazada<Integer>(primerNodoEsperado);
    l.insertarAntes(l.obtenerPrimero(), n);
    
    listaEsperada.insertarAntes(listaEsperada.obtenerPrimero(), nodoAInsertar);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test
  public void insertarAntesElementoVacíoListaConVariosElementos(){
    int v1 = 14, v2 = 9, v3 = 1, v4 = 3;
    
    ListaEnlazada<Integer>.Nodo n1Esperado = l.new Nodo(v1);
    ListaEnlazada<Integer>.Nodo n2Esperado = l.new Nodo(v2);
    ListaEnlazada<Integer>.Nodo n3Esperado = l.new Nodo(v3);
    ListaEnlazada<Integer>.Nodo n4Esperado = l.new Nodo(v4);
    
    ListaEnlazada<Integer>.Nodo n1 = l.new Nodo(v1);
    ListaEnlazada<Integer>.Nodo n2 = l.new Nodo(v2);
    ListaEnlazada<Integer>.Nodo n3 = l.new Nodo(v3);
    ListaEnlazada<Integer>.Nodo n4 = l.new Nodo(v4);
    
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(n1Esperado);
    listaEsperada.insertarUltimo(n2Esperado);
    listaEsperada.insertarUltimo(n3Esperado);
    listaEsperada.insertarUltimo(n4Esperado);
    
    l = new ListaEnlazada<Integer> (n1);
    l.insertarUltimo(n2);
    l.insertarUltimo(n3);
    l.insertarUltimo(n4);
    
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo();
    n = l.new Nodo();
    
    listaEsperada.insertarAntes(n3Esperado, nodoAInsertar);
    l.insertarAntes(n3, n);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }

  @Test
  public void insertarAntesElementoNoVacioListaConVariosElementos(){
    int v1 = 14, v2 = 9, v3 = 1, v4 = 3;
    
    ListaEnlazada<Integer>.Nodo n1 = l.new Nodo(v1);
    ListaEnlazada<Integer>.Nodo n2 = l.new Nodo(v2);
    ListaEnlazada<Integer>.Nodo n3 = l.new Nodo(v3);
    ListaEnlazada<Integer>.Nodo n4 = l.new Nodo(v4);
    
    ListaEnlazada<Integer>.Nodo n1Esperado = l.new Nodo(v1);
    ListaEnlazada<Integer>.Nodo n2Esperado = l.new Nodo(v2);
    ListaEnlazada<Integer>.Nodo n3Esperado = l.new Nodo(v3);
    ListaEnlazada<Integer>.Nodo n4Esperado = l.new Nodo(v4);
    
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(n1Esperado);
    listaEsperada.insertarUltimo(n2Esperado);
    listaEsperada.insertarUltimo(n3Esperado);
    listaEsperada.insertarUltimo(n4Esperado);
    
    l = new ListaEnlazada<Integer> (n1);
    l.insertarUltimo(n2);
    l.insertarUltimo(n3);
    l.insertarUltimo(n4);
    
    int v = 20;
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo(v);
    n = l.new Nodo(v);
    
    listaEsperada.insertarAntes(n3Esperado, nodoAInsertar);
    l.insertarAntes(n3, n);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }

  @Test (expected = ListaException.class)
  public void insertarAntesElementoVacioDelanteElementoNoExiste(){
    int v1 = 14, v2 = 9, v3 = 13;
    
    ListaEnlazada<Integer>.Nodo n1Esperado = l.new Nodo(v1);
    ListaEnlazada<Integer>.Nodo n2Esperado = l.new Nodo(v2);
    ListaEnlazada<Integer>.Nodo n3Esperado = l.new Nodo(v3);
    
    ListaEnlazada<Integer>.Nodo n1 = l.new Nodo(v1);
    ListaEnlazada<Integer>.Nodo n2 = l.new Nodo(v2);
    ListaEnlazada<Integer>.Nodo n3 = l.new Nodo(v3);
    
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(n1Esperado);
    listaEsperada.insertarUltimo(n2Esperado);
    listaEsperada.insertarUltimo(n3Esperado);
    
    l = new ListaEnlazada<Integer>(n1);
    l.insertarUltimo(n2);
    l.insertarUltimo(n3);

    int v = 45;
    ListaEnlazada<Integer>.Nodo nodoNoEnListaEsperada = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo nodoNoEnL = l.new Nodo(v);
    
    v = 32;
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo(v);
    n = l.new Nodo(v);
    
    listaEsperada.insertarAntes(nodoNoEnListaEsperada, nodoAInsertar);
    
    fail ("Aquí nunca debe llegar");
    
    l.insertarAntes(nodoNoEnL, n);
  }
  
  @Test (expected = ListaException.class)
  public void insertarDespuesElementoListaVacia(){
    l = new ListaEnlazada<Integer>();
    n = l.new Nodo(2);
    
    l.insertarDespues(l.obtenerPrimero(), n);
    
    fail("Aquí nunca debe llegar");
  }
  
  @Test
  public void insertarDespuesElementoVacioListaUnElemento(){
    int v = 14;
    ListaEnlazada<Integer>.Nodo nodoPrimeroEsperado = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo nodoPrimero = l.new Nodo(v);
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(nodoPrimeroEsperado);
    l = new ListaEnlazada<Integer>(nodoPrimero);

    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo();
    
    listaEsperada.insertarDespues(listaEsperada.obtenerPrimero(), nodoAInsertar);
    l.insertarDespues(l.obtenerPrimero(), n);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test
  public void insertarDespuesElementoNoVacioListaUnElemento(){
    int v = 14;
    ListaEnlazada<Integer>.Nodo nodoPrimeroEsperado = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo nodoPrimero = l.new Nodo(v);
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(nodoPrimeroEsperado);
    l = new ListaEnlazada<Integer>(nodoPrimero);

    v = 9;
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo(v);
    n = l.new Nodo(v);
    
    listaEsperada.insertarDespues(listaEsperada.obtenerPrimero(), nodoAInsertar);
    l.insertarDespues(l.obtenerPrimero(), n);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test
  public void insertarDespuesElementoVacioListaVariosElementos(){
    int v1 = 14, v2 = 9, v3 = 1, v4 = 3;
    
    ListaEnlazada<Integer>.Nodo n1 = l.new Nodo(v1);
    ListaEnlazada<Integer>.Nodo n2 = l.new Nodo(v2);
    ListaEnlazada<Integer>.Nodo n3 = l.new Nodo(v3);
    ListaEnlazada<Integer>.Nodo n4 = l.new Nodo(v4);
    
    ListaEnlazada<Integer>.Nodo n1Esperado = l.new Nodo(v1);
    ListaEnlazada<Integer>.Nodo n2Esperado = l.new Nodo(v2);
    ListaEnlazada<Integer>.Nodo n3Esperado = l.new Nodo(v3);
    ListaEnlazada<Integer>.Nodo n4Esperado = l.new Nodo(v4);
    
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(n1Esperado);
    listaEsperada.insertarUltimo(n2Esperado);
    listaEsperada.insertarUltimo(n3Esperado);
    listaEsperada.insertarUltimo(n4Esperado);
    
    l = new ListaEnlazada<Integer> (n1);
    l.insertarUltimo(n2);
    l.insertarUltimo(n3);
    l.insertarUltimo(n4);

    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo();
    n = l.new Nodo();

    listaEsperada.insertarDespues(n3Esperado, nodoAInsertar);
    l.insertarDespues(n3, n);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test
  public void insertarDespuesElementoNoVacioListaVariosElementos(){
    int v1 = 14, v2 = 9, v3 = 1, v4 = 3;
    
    ListaEnlazada<Integer>.Nodo n1 = l.new Nodo(v1);
    ListaEnlazada<Integer>.Nodo n2 = l.new Nodo(v2);
    ListaEnlazada<Integer>.Nodo n3 = l.new Nodo(v3);
    ListaEnlazada<Integer>.Nodo n4 = l.new Nodo(v4);
    
    ListaEnlazada<Integer>.Nodo n1Esperado = l.new Nodo(v1);
    ListaEnlazada<Integer>.Nodo n2Esperado = l.new Nodo(v2);
    ListaEnlazada<Integer>.Nodo n3Esperado = l.new Nodo(v3);
    ListaEnlazada<Integer>.Nodo n4Esperado = l.new Nodo(v4);
    
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(n1Esperado);
    listaEsperada.insertarUltimo(n2Esperado);
    listaEsperada.insertarUltimo(n3Esperado);
    listaEsperada.insertarUltimo(n4Esperado);
    
    l = new ListaEnlazada<Integer> (n1);
    l.insertarUltimo(n2);
    l.insertarUltimo(n3);
    l.insertarUltimo(n4);
    
    int v = 20;
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo(v);
    n = l.new Nodo(v);

    listaEsperada.insertarDespues(n3Esperado, nodoAInsertar);
    l.insertarDespues(n3, n);
    
    assertEquals(listaEsperada.toString(), l.toString());
  }
  
  @Test (expected = ListaException.class)
  public void insertarDespuesElementoVacioDelanteElementoNoExiste(){
    int v1 = 14, v2 = 9, v3 = 13;
    
    ListaEnlazada<Integer>.Nodo n1Esperado = l.new Nodo(v1);
    ListaEnlazada<Integer>.Nodo n2Esperado = l.new Nodo(v2);
    ListaEnlazada<Integer>.Nodo n3Esperado = l.new Nodo(v3);
    
    ListaEnlazada<Integer>.Nodo n1 = l.new Nodo(v1);
    ListaEnlazada<Integer>.Nodo n2 = l.new Nodo(v2);
    ListaEnlazada<Integer>.Nodo n3 = l.new Nodo(v3);
    
    ListaEnlazada<Integer> listaEsperada = new ListaEnlazada<Integer>(n1Esperado);
    listaEsperada.insertarUltimo(n2Esperado);
    listaEsperada.insertarUltimo(n3Esperado);
    
    l = new ListaEnlazada<Integer>(n1);
    l.insertarUltimo(n2);
    l.insertarUltimo(n3);

    int v = 45;
    ListaEnlazada<Integer>.Nodo nodoNoEnListaEsperada = l.new Nodo(v);
    ListaEnlazada<Integer>.Nodo nodoNoEnL = l.new Nodo(v);
    
    v = 32;
    ListaEnlazada<Integer>.Nodo nodoAInsertar = l.new Nodo(v);
    n = l.new Nodo(v);
    
    listaEsperada.insertarDespues(nodoNoEnListaEsperada, nodoAInsertar);
    
    fail ("Aquí nunca debe llegar");
    
    l.insertarDespues(nodoNoEnL, n);
  }
}
