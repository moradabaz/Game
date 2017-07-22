

package topos.juego;

/**
 * Este apartado tiene como objetivo iniciar la implementacion de la dinamica del juego. 
 * Las clases desarrolladas hasta este punto comenzaran a ser adaptadas para definir 
 * el comportamiento de los componentes del juego. Asi mismo, se incluira una nueva clase, GestionJuego,
 * que tendra la responsabilidad de gestionar el estado del juego (tiempo restante, disparos pendientes, etc.)
 * y el funcionamiento de las partidas.
 *   Ademas, en la puntucion hay dos propiedades: Puntos pendientes y puntos totales.
 *   Los puntos totales son inmodificables. Los puntos pendientes al principio son iguales que los puntos
 *   totales pero van decrementandose cada vez que un elemento puntuable es eleminado.
 * 
 * @author Morad Abbou Azaz y Juan Antonio Arnau Sanchez.
 *
 */
public class GestionJuego {
	
	private int puntospendientes;
	private int puntosTotales;
	private int puntos;					//	Puntos del Juego
	private int disparosRestantes;		//	Disparos del juego
	private int segundos;			//	Tiempo maximo
	private long limiteTiempo;			// limite maximo del tiempo
	
	
	
	/**
	 * Esta operacion se encarga de construir el objeto. Para ello inicializa los atributos
	 * con los parametros que toma.
	 * Se inicializan los puntos pendientes y los puntos totales.
	 * @param segundos	El numero maximo de segundos que tiene el juego.
	 * @param disparosRestantes	El numero maximo de disparos que tiene. 
	 * @param nmax La puntuacion maxima que se puede llegar a alcanzar.
	 */
	public GestionJuego(int segundos, int disparosRestantes, int nmax) {
		if((segundos<0) || (disparosRestantes<0) || (nmax<0))
			throw new IllegalArgumentException("El valor de este parametro no puede ser negativo");
		this.puntos = 0;
		this.segundos = segundos;
		this.disparosRestantes = disparosRestantes;
		this.puntosTotales = nmax;
		this.puntospendientes = nmax;
		
	}
	
	


	/**
	 * Esta operacion pone en marcha la partida. 
	 * A partir del momento en el que se ejecuta el tiempo del juego comienza a correr. 
	 * Con el fin de controlar el momento en el que comienza la partida,
	 * se recomienda declarar una marca de tiempo que haga referencia al instante en el que ha comenzado 
	 */
	public void arrancar() {
		
		long ahora = System.currentTimeMillis();
		this.limiteTiempo = ahora + segundos * 1000;
		
		// La mezcla de paneles se produce a media partida
		
	}
	
	
	/**
	 * Una partida ha agotado su tiempo si la propiedad segundos restantes tiene valor 0.
	 * @return Devuelve un booleano que indica si el tiempo ha finalizado o no.
	 */
	public boolean tiempoFinalizado() {
		
		return System.currentTimeMillis() > this.limiteTiempo;
	}
	
	/**
	 * Este metodo consiste en retornar el tiempo que le queda al juego para
	 * finaliza, restando el tiempo actual que ha transcurrido al tiempo maximo
	 * del juego. Si el tiempo es igual a 0, entonces retorna el valor cero.
	 * En caso contrario retornara el tiempo restante.
	 * @return	Devuelve el tiempo que le queda al juego para terminar.
	 */
	public int getSegundosRestantes() {
		
		long tiempoRestante = this.limiteTiempo - System.currentTimeMillis();
		if (tiempoRestante <= 0){
			return 0; }
		else {
			return (int) (1 + (tiempoRestante / 1000));
		}
	}
	
	
	/**
	 * Consulta una partida si esta en juego o no.
	 * Una partida esta juego si se cumplen dos condiciones: 
	 * 1) el tiempo no ha finalizado.
	 * 2) el número de disparos restantes es superior a 0.
	 * 
	 * @return Devuelve un valor verdadero si el tiempo aun no ha terminado, o aun hay disparos
	 * disponibles. Devuelve un valor falso si esas dos propiedades no se cumplen.
	 */
	public boolean enJuego() {
		
		return (System.currentTimeMillis() <= this.limiteTiempo && disparosRestantes > 0) ;
	}
	
	/**
	 * Consulta del numero de disparos restantes del juego.
	 * @return	Devuelve los disparos restantes del jugador.
	 */
	public int getDisparosRestantes() {
		return disparosRestantes;
	}
	/**
	 * 
	 * @return Devuelve los puntos totales del escenario.
	 */
	public int getPuntoTotales()
	{
		return puntosTotales;
	}
	
	
	/**
	 * Consulta de la puntuacion del juego.
	 * @return Devuelve la puntuacion del jugador.
	 */
	public int getPuntos() {
		return puntos;
	}
	

	
	/**
	 * Incrementa la puntuacion del jugador.
	 * @param i Parametro del valor que se incrementa a la puntuacion.
	 */
	public void addPuntos(int i) {		
		puntos+=i;
	}
	/**
	 * Decrementa, en una quantity, la puntucion del juego
	 * @param i El valor de la quantity que se decrementa.
	 */
	public void deletePuntos(int i){
		puntos-=i;
	}
	
	/**
	 * Se pierde o consume un disparo.
	 */
	public void consumeDisparo() {		
		disparosRestantes--;
	}
	
	/**
	 * Anade un numero de disparos a los dispacios del jugador.
	 * @param disparos	Numero de disparos que se le anaden al jugador.
	 */
	public void addDisparos(int disparos) {
		
		this.disparosRestantes += disparos;
	}
	
	
	/** 
	 * @return Devuelve verdadero si aun hay disparos disponibles
	 * para disparar.
	 */
	public boolean haydisparos() {
		
		return disparosRestantes > 0;
	}

	/**
	 * Este metodo anade una quantity de segundos al tiempo
	 * @param n Cantidad que se le añade al tiempo
	 */
	public void addSegundos(int n)
	{
		this.segundos+=n;
	}
	/**
	 * Este metodo se encarga de decrementar los puntos pendientes.
	 * @param n Parametro del valor en el que se decrementan los puntos
	 * pendientes
	 */
	public void decPuntosPendientes(int n)
	{
		 puntospendientes -= n;
	}
	
	/**
	 * 
	 * @return Devuelve los puntos pendientes del escenario.
	 */
	public int getPuntosPendientes()
	{
		return this.puntospendientes;
	}
}