package Practica2;

/**
 * Implementacion de AdultBike como tipo particular de la clase Bike
 * 
 * @author CQFidalgo
 *
 */

public class AdultBike extends Bike {

	/**
	 * Inicializacion de AdultBike con argumentos
	 * 
	 * @param marca de la bicibleta
	 * @param modelo de la bicibleta
	 * @param peso de la bicibleta
	 * @param platos: numero de platos de la bicibleta
	 * @param pinones: numero de pinones de la bicibleta
	 * @param talla: talla de la bicicleta
	 * 
	 * @assert.pre La talla ha de cumplir unos requisitos para ser correcta
	 */
	public AdultBike(String marca, String modelo, double peso, int platos, int pinones, String talla) {
		super(marca, modelo, peso, platos, pinones, talla);
		assert tallaValida();
	}

	/**
	 * Metodo que convierte una bicicleta a String
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "\n  Tipo de bicicleta: Adulto" + super.toString();
	}

	/**
	 * Compara los atributos de un objeto con una bike
	 * 
	 * @param bicicleta a comparar
	 * 
	 * @return Si es el mismo objeto o no
	 */
	@Override
	public boolean equals(Object otra) {
		return super.equals(otra);
	}

	/**
	 * Devuelve el deposito que hay que pagar segun el descuento que proceda
	 * 
	 * @param deposito que se ha establedido de antemano por el ayuntamiento
	 * 
	 * @return deposito a pagar segun el descuento que proceda
	 * 
	 * @assert.pre El deposito ha de ser mayor de 0
	 */
	@Override
	public double getDepositToPay(double deposit) {
		assert deposit > 0.0;

		return deposit; // No hace descuento a los adultos
	}

	// Validacion de la talla
	private boolean tallaValida() {
		// Tallas validas: S, M, L, XL
		assert (super.getTalla().equalsIgnoreCase("S") || super.getTalla().equalsIgnoreCase("M")
				|| super.getTalla().equalsIgnoreCase("L") || super.getTalla().equalsIgnoreCase("XL"));

		return true;
	}

}
