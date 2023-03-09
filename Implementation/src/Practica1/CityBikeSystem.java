package Practica1;

import java.util.ArrayList;
import java.util.List;
import fabricante.externo.tarjetas.TarjetaMonedero;

/**
 * Implementacion de un CityBikeSystem
 * 
 * @author CQFidalgo
 * 
 * @see http://www.arumeinformatica.es/utiles/convertir-coordenadas-gps/
 * @see https://www.coordenadas-gps.com/sistema-de-coordenadas
 * 
 */

public class CityBikeSystem {

	/*
	 * Atributos de la clase
	 */
	private double precio; // tarifa
	private List<CityBikeParkingPoint> aparcamientosCiudad;
	// lista de los aparcamientos de la ciudad

	/**
	 * Inicializacion por defecto de una maquina
	 */
	public CityBikeSystem() {
		precio = 0.0;
		aparcamientosCiudad = new ArrayList<CityBikeParkingPoint>();
	}

	/**
	 * Inicializacion del sistema con argumentos
	 * 
	 * @param Precio
	 * @assert.pre El precio ha de ser mayor de 0
	 */
	public CityBikeSystem(double precio) {
		assert precio > 0;

		this.precio = precio;
		aparcamientosCiudad = new ArrayList<CityBikeParkingPoint>();
	}

	/**
	 * Obtener la lista de todos los aparcamientos
	 * 
	 * @return Lista de objetos CityBikeParkingPoint
	 */
	public List<CityBikeParkingPoint> getAparcamientosCiudad() {
		return aparcamientosCiudad;
	}

	/**
	 * Obtener el precio actual de la tarifa
	 * 
	 * @return Precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Modificar precio de alquiler
	 * 
	 * @param newPrecio: nueva tarifa
	 * 
	 * @assert.pre El precio ha de ser mayor que 0
	 */
	public void setPrecio(double newPrecio) {
		assert newPrecio > 0;

		precio = newPrecio;
	}

	/**
	 * Crear un nuevo aparcamiento
	 * 
	 * @param nAnclajes: numero de anclajes que tendra el aparcamiento
	 * @param id: identificador del aparcamiento distinto de los aparcamientos
	 *            actuales
	 * @param gps: posicion GPS del aparcamiento
	 * 
	 * @assert.pre El numero de anclajes debe ser mayor que 0
	 * @assert.pre El id debe ser mayor que 0
	 * @assert.pre El id no debe estar repetido dentro del sistema
	 * @assert.pre Las coordenadas en grados decimales constan de dos numeros
	 */
	// Gps en coordenadas grados decimales
	public void nuevoAparcamientoGD(int nAnclajes, int id, double[] gps) {
		assert nAnclajes > 0;
		assert id > 0;
		assert !comprobarId(id);
		assert gps.length == 2;

		CityBikeParkingPoint aparcamientoNuevo = new CityBikeParkingPoint(nAnclajes, id, gps);
		addAparcamiento(aparcamientoNuevo);
	}

	/**
	 * Crear un nuevo aparcamiento
	 * 
	 * @param nAnclajes: numero de anclajes que tendra el aparcamiento
	 * @param id: identificador del aparcamiento
	 * @param gps: posicion GPS del aparcamiento
	 * 
	 * @assert.pre El numero de anclajes ha de mayor que 0
	 * @assert.pre El id debe ser positivo mayor que 0
	 * @assert.pre El id no debe estar repetido dentro del sistema
	 * @assert.pre Las coordenadas GMS se dividen en dos grupos, uno para
	 *             latitud y otro para longitud
	 * @assert.pre Las coordenadas GMS constan de 4 elementos: grados, minutos,
	 *             segundos y punto cardinal
	 */
	// Gps en coordenadas grados, minutos y segundos sexagesimales
	public void nuevoAparcamientoGMS(int nAnclajes, int id, String[][] gps) {
		assert nAnclajes > 0;
		assert id > 0;
		assert !comprobarId(id);
		assert gps.length == 2;
		assert gps[0].length == 4 && gps[1].length == 4;

		CityBikeParkingPoint aparcamientoNuevo = new CityBikeParkingPoint(nAnclajes, id, gps);
		addAparcamiento(aparcamientoNuevo);
	}

	/**
	 * Añadir un nuevo aparcamiento ya creado con anterioridad
	 * 
	 * @param nuevo: aparcamiento que se quiere añadir al sistema
	 * 
	 * @assert.pre El id no debe estar repetido dentro del sistema
	 */
	public void addAparcamiento(CityBikeParkingPoint nuevo) {
		assert !comprobarId(nuevo.getId());

		aparcamientosCiudad.add(nuevo);
	}

	/**
	 * Eliminar un aparcamiento según su id
	 * 
	 * @param id: identificador del aparcamiento
	 * 
	 * @assert.pre La id ha de ser mayor que 0
	 * @assert.pre Ha de existir el aparcamiento para poder eliminarlo
	 */
	public void eliminarAparcamiento(int id) {
		assert id > 0;
		assert comprobarId(id);

		aparcamientosCiudad.remove(posicionId(id));
	}

	/**
	 * Comprobar si el Id que se quiere utilizar está ya en el sistema
	 * 
	 * @param otherId: Id que se quiere comprobar
	 * 
	 * @return Si el Id está en el sistema o no
	 * 
	 * @assert.pre La Id ha de ser mayor que 0
	 */
	public boolean comprobarId(int otherId) {
		assert otherId > 0;

		boolean existe = false;// no existe en el sistema

		for (int i = 0; i < aparcamientosCiudad.size(); i++) {
			if (aparcamientosCiudad.get(i).getId() == otherId) {
				existe = true;// existe en el sistema
			}
		}
		return existe;
	}

	// Metodo que devuelve la posición del objeto con Id = id en la Lista
	private int posicionId(int id) {
		int index = 0;

		for (int i = 0; i < aparcamientosCiudad.size(); i++) {
			if (aparcamientosCiudad.get(i).getId() == id) {
				index = i;
			}
		}
		return index; // Devuelve el indice que ocupa en aparcamientosCiudad el
						// aparcamiento con la Id introducida
	}

	// Metodo que devuelve el aparcamiento, dentro del sistema, con el id
	// seleccionado
	private CityBikeParkingPoint aparcamientoId(int id) {
		CityBikeParkingPoint aparcamientoSeleccionado = new CityBikeParkingPoint();
		;

		for (int i = 0; i < aparcamientosCiudad.size(); i++) {
			if (aparcamientosCiudad.get(i).getId() == id) {
				aparcamientoSeleccionado = aparcamientosCiudad.get(i);
			}
		}

		return aparcamientoSeleccionado; // Devuelve el aparcamiento
											// correspondiente a la Id
											// introducida
	}

	/**
	 * Obtener la lista de todos los aparcamientos con huecos disponibles
	 * 
	 * @return Lista de objetos CityBikeParkingPoing con espacios disponibles
	 */
	public List<CityBikeParkingPoint> conEspaciosDisponibles() {
		List<CityBikeParkingPoint> conEspaciosDisponibles = new ArrayList<CityBikeParkingPoint>();
		CityBikeParkingPoint aux;

		for (int i = 0; i < aparcamientosCiudad.size(); i++) {
			aux = aparcamientosCiudad.get(i);
			for (int j = 1; j <= aux.getTotalAnclajes(); j++) {
				if (aux.estadoModulo(j) == false) {// Cuando false entonces hay
													// espacio
					conEspaciosDisponibles.add(aux);
					break;
				}
			}
		}
		return conEspaciosDisponibles;
	}

	/**
	 * Obtener la lista de todos los aparcamientos con bicicletas disponibles
	 * (algun True)
	 * 
	 * @return Lista de objetos CityBikeParkingPoing con bicicletas disponibles
	 */
	public List<CityBikeParkingPoint> conBicicletasDisponibles() {
		List<CityBikeParkingPoint> conBicisDisponibles = new ArrayList<CityBikeParkingPoint>();
		CityBikeParkingPoint aux;
		for (int i = 0; i < aparcamientosCiudad.size(); i++) {
			aux = aparcamientosCiudad.get(i);
			for (int j = 1; j <= aux.getTotalAnclajes(); j++) {
				if (aux.estadoModulo(j)) {// Cuando True entonces hay bici
					conBicisDisponibles.add(aux);
					break;
				}
			}
		}
		return conBicisDisponibles;
	}

	/**
	 * Obtener la lista de todos los aparcamientos cercanos a nuestra posicion
	 * en un radio de R metros
	 * 
	 * @param radio: radio de R metros en el que se desean buscar parkings
	 * @param gps: coordenadas en grados decimales a partir de las cuales se
	 *            desea buscar
	 * 
	 * @return Lista de objetos CityBikeParkingPoint con todos los aparcamientos
	 *         cercanos a la coordenada introducida en un radio de R metros
	 * 
	 * @assert.pre Las coordenadas en grados decimales constan de dos numeros
	 * @assert.pre El radio ha de ser mayor que 0
	 */
	// gps en coordenadas grados decimales
	public List<CityBikeParkingPoint> aparcamientosCercanosGD(double[] gps, double radio) {
		assert gps.length == 2;
		assert radio > 0;

		List<CityBikeParkingPoint> aparcamientosRadio = new ArrayList<CityBikeParkingPoint>();
		double aux = 0.0;

		for (int i = 0; i < aparcamientosCiudad.size(); i++) {
			aux = aparcamientosCiudad.get(i).distanciaDesdeCoordenada(gps);
			if (aux <= radio) {
				aparcamientosRadio.add(aparcamientosCiudad.get(i));
			}
		}
		return aparcamientosRadio;
	}

	/**
	 * Obtener la lista de todos los aparcamientos cercanos a nuestra posicion
	 * en un radio de R metros
	 * 
	 * @param radio: radio de R metros en el que se desean buscar parkings
	 * @param gms: coordenadas en grados sexagesimales a partir de las cuales se
	 *            desea buscar
	 * 
	 * @return Lista de objetos CityBikeParkingPoint con todos los aparcamientos
	 *         cercanos en un radio de R metros
	 * 
	 * @assert.pre Las coordenadas GMS se dividen en dos grupos, uno para
	 *             latitud y otro para longitud
	 * @assert.pre Las coordenadas en GMS constan de grados, minutos, segundos y
	 *             punto cardinal (4 elementos)
	 * @assert.pre El radio ha de ser mayor que 0
	 */
	public List<CityBikeParkingPoint> aparcamientosCercanosGMS(String[][] gms, double radio) {
		assert gms.length == 2;
		assert gms[0].length == 4 && gms[1].length == 4;
		assert radio > 0;

		List<CityBikeParkingPoint> aparcamientosRadio = new ArrayList<CityBikeParkingPoint>();
		double aux = 0.0;
		double gps[] = new double[2];

		for (int i = 0; i < aparcamientosCiudad.size(); i++) {

			for (int j = 0; j < 2; j++) {
				gps[j] = aparcamientosCiudad.get(i).convertirGMSaGD(gms)[j];
			}

			aux = aparcamientosCiudad.get(i).distanciaDesdeCoordenada(gps);
			if (aux <= radio) {
				aparcamientosRadio.add(aparcamientosCiudad.get(i));
			}
		}
		return aparcamientosRadio;
	}

	/**
	 * Se encarga del proceso de alquiler de una bicicleta. Descuenta el precio
	 * del alquiler al saldo actual de la tarjeta e indica el nuevo estado del
	 * anclaje (libre) siempre y cuando se introduzca una credencial correcta.
	 * 
	 * @param tarjeta: Tarjeta con la que se realiza la venta
	 * @param credencial: Codigo aportado por el cliente
	 * @param id: Identificador del aparcamiento
	 * @param anclaje: Identificador del anclaje dentro del aparcamiento
	 * 
	 * @return Tarjeta con el saldo modificado tras el alquiler
	 * 
	 * @assert.pre La id ha de ser mayor que 0
	 * @assert.pre La tarjeta tiene que tener saldo suficiente para poder
	 *             descontar el precio del alquiler
	 * @assert.pre Ha de existir un aparcamiento con la Id introducida
	 * @assert.pre El anclaje tiene que pertenecer al aparcamiento
	 */
	public TarjetaMonedero alquilarBicicleta(TarjetaMonedero tarjeta, int id, int anclaje) {
		assert id > 0;
		assert tarjeta.getSaldoActual() >= precio;
		assert comprobarId(id);
		assert (anclaje > 0 && anclaje <= aparcamientoId(id).getTotalAnclajes());
		// descuenta del saldo actual de la tarjeta el precio del alquiler
		// aportandole una credencial correcta
		tarjeta.descontarDelSaldo("6Z1y00Nm31aA-571", precio);
		aparcamientosCiudad.get(posicionId(id)).desanclarBici(anclaje);

		return tarjeta;
	}

	/**
	 * Se encarga del proceso de devolucion de la bicicleta. Suma el precio del
	 * alquiler al saldo actual de la tarjeta e indica el nuevo estado del
	 * anclaje (ocupado).
	 * 
	 * @param tarjeta: Tarjeta con la que se realiza la venta
	 * @param credencial: Codigo aportado por el cliente
	 * @param id: Identificador del aparcamiento
	 * @param anclaje: Identificador del anclaje denro del aparcamiento
	 * 
	 * @return Tarjeta con el saldo inicial tras haber sido devuelto el importe
	 *         del alquiler
	 * 
	 * @assert.pre La Id ha de ser mayor que 0
	 * @assert.pre Ha de existir un aparcamiento con la Id introducida
	 * @assert.pre El anclaje debe pertenecer al aparcamiento
	 */
	public TarjetaMonedero devolverBicicleta(TarjetaMonedero tarjeta, int id, int anclaje) {
		assert id > 0;
		assert comprobarId(id);
		assert (anclaje > 0 && anclaje <= aparcamientoId(id).getTotalAnclajes());

		tarjeta.recargaSaldo("A156Bv09_1zXo894", precio);
		aparcamientosCiudad.get(posicionId(id)).anclarBici(anclaje);

		return tarjeta;
	}

}
